package com.aster.podcastManager;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class PodcastService {
    // Os seguintes metodos apenas simulam comportamentos
    public Podcast findPodcastById(Integer id) {
        Podcast podcast = new Podcast();
        podcast.setId(id);
        podcast.setName("Meu podcast");
        podcast.setUrl("https://www.meupodcast.com.br/");
        podcast.setSecretToker("69haha");
        return podcast;
    }
    public Podcast createPodcast(PodcastCreationDTO newPodcast) {
        Podcast podcast = new Podcast();
        podcast.setId(new Random().nextInt(0, 1000));
        podcast.setSecretToker("super-secret-toukhen");
        podcast.setName(newPodcast.name());
        podcast.setUrl(newPodcast.url());
        return podcast;
    }
}
