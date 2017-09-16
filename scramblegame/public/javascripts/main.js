var app = app || {};

(function ($) {

   var Word = Backbone.Model.extend({
      defaults: function() {
        return {
          value: "empty ...",
          done: false
        };
      }
   });

   var WordList = Backbone.Collection.extend({
      model: Word
   });

   var WordView = Backbone.View.extend({
      tagName:  "li",

      template: _.template($('#item-template').html()),

      initialize: function() {
        this.listenTo(this.model, 'change', this.render);
        this.listenTo(this.model, 'destroy', this.remove);
      },

      render: function() {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
      },

  });

  var WordListView = Backbone.View.extend({
       tagName: 'ul',

       initialize: function() {

       },

       getResult: function(word) {
         this.collection.fetch({
           url: "/scramblegame/compoundWord/"+word,
           success: function(model) {
             v.setTotalAnswers(_.size(model.toJSON()));
           }
        });
       },

       render: function() {
         this.collection.each(function(item) {
           if (item.get("done") === false) {
             var wordView = new WordView({ model: item });
             this.$el.append(wordView.render().el);
           }
         }, this);
         return this;
       },

       clear: function() {
         this.collection.reset();
         this.$el.empty();
         return false;
       },

       check: function(input) {
         var parent = this;
         var found = false;
         this.collection.each(function(item) {
           if (item.get("value").trim().localeCompare(input.trim()) === 0) {
             v.addCorrectAnswers();
             item.set("done", true);
             found = true;
             return true;
           }
         });
         return found;
       }
    });

    var App = Backbone.Model.extend({
        urlRoot: "/scramblegame/next",
        defaults: function() {
          return {
            value: "empty ...",
            correctAnswers: 0,
            totalAnswers: 0
          };
        }
    });

    var AppView = Backbone.View.extend({

      el: "#content",

      messageValue: "val",

      initialize: function () {
        this.listenTo(this.model, 'change', this.render);
        this.model.fetch({
          success: function(model) {
            wordListView.getResult(model.get("value"));
          }
        });
      },

      events: {
        "click #getNextGame": "getNextGame",
        "click #showResult": "showResult"
      },

      render: function () {
        this.$el.html(_.template( $("#game_content").html(), this.model.toJSON()));
        return this;
      },

      getNextGame: function() {
        this.model.fetch({
          success: function (model) {
            wordListView.clear();
            wordListView.getResult(model.get("value"));
            guessListView.clear();
            model.set("correctAnswers", 0);
          }
        });
      },

      showResult: function() {
        $("#word-list").append(wordListView.render().el);
      },

      addCorrectAnswers: function() {
        this.model.set("correctAnswers", this.model.get("correctAnswers")+1);
      },

      setTotalAnswers: function(number) {
        this.model.set("totalAnswers", number);
      },

      getTypingPattern: function() {
        return new RegExp("^["+this.model.get("value")+"]*$");
      }
    });

    var Guess = Backbone.Model.extend({
      defaults: {
        value: 'Guest Word',
        correct: false
      }
    });

    var GuessCollection = Backbone.Collection.extend({
      model: Guess
    });

    var GuessListView = Backbone.View.extend({
      tagName: 'ul',

      initialize: function () {
        this.listenTo(this.collection, 'change', this.render);
      },

      render: function() {
        return this;
      },

      push: function(guessWord) {
        if (_.where(this.collection.toJSON(), {value: guessWord}).length == 0) {          
          this.collection.push({"value": guessWord});
          var newGuess = new Guess({value: guessWord, correct: wordListView.check(guessWord)});
          var guessView = new GuessView({model: newGuess});
          this.$el.append(guessView.render().el);
        }
      },

      clear: function() {
        this.collection.reset();
        this.$el.empty();
        return false;
      },
    });

    var GuessView = Backbone.View.extend({
        tagName: 'li',
        template: _.template($('#guess_word_template').html()),
        render: function(){
            this.$el.html( this.template(this.model.toJSON()));
            return this;
        }
    });

   var wordListView = new WordListView({ collection: new WordList() });
   var v = new AppView({ model: new App()});

   var guessListView = new GuessListView({ collection: new GuessCollection([]) });

   var containerWord = [];
   $(document).on('keypress', function(e) {
     var key = e.which;
     if (key == 13) {
       guessListView.push(containerWord.join(""));
       $("#word-list").html(guessListView.render().$el);
       containerWord = [];
     } else if (v.getTypingPattern().test(String.fromCharCode(e.which))) {
       containerWord.push(String.fromCharCode(key));
     }
   });
   $(document).on('keyup', function(e) {
     var key = e.which;
     if (key == 8) {
       containerWord.splice(-1,1);
     }
   });
})(jQuery);