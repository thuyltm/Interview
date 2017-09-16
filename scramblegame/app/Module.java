import repository.WordRepository;
import repository.WordRepositoryImpl;

import com.google.inject.AbstractModule;


/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {
        // Ask Guice to create an instance of WordRepository when the
        // application starts.
        // Set WordRepositoryImpl as the implementation for WordRepository.
        bind(WordRepository.class).to(WordRepositoryImpl.class).asEagerSingleton();
    }

}
