package ru.lukyanov.config;

import ru.lukyanov.repo.ActorRepo;
import ru.lukyanov.repo.MovieRepo;
import ru.lukyanov.repo.dbConnection.DBConnection;
import ru.lukyanov.service.ActorService;
import ru.lukyanov.service.MovieService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("ru.lukyanov")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public DBConnection getDataSource(){
        return new DBConnection();
    }

    @Bean
    public ActorRepo getActorRepo(){ return new ActorRepo(getDataSource());}

    @Bean
    public MovieRepo getMovieRepo(){ return new MovieRepo(getDataSource());}

    @Bean(name = {"serviceA", "serviceB"}, initMethod = "init", destroyMethod = "destroy")
    // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ActorService getActorService(){return new ActorService(getActorRepo());}

    @Bean
    public MovieService getMovieService(){return new MovieService(getMovieRepo());}

}