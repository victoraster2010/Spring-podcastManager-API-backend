package com.aster.podcastManager;


import java.util.Random;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/podcasts")
public class PodcastRestController {
  @GetMapping
  public String getRoot() {
    return "Yay podcasts!";
  }

  Podcast findPodcastById(Integer id) {
    Podcast podcast = new Podcast();
    podcast.setId(id);
    podcast.setName("Meu podcast");
    podcast.setUrl("https://www.meupodcast.com.br/");
    podcast.setSecretToker("69haha");
    return podcast;
  }

  @GetMapping("/{id}")
  public ResponseEntity<PodcastDTO> getPodcast(@PathVariable Integer id) {
    if (id > 1000) 
      return ResponseEntity.notFound().build();

    Podcast result = findPodcastById(id);
    PodcastDTO podcastDTO = new PodcastDTO(result.getId(), result.getName(), result.getUrl());
    // return String.format("Você pediu pelo podcast com id: %d", id);
    return ResponseEntity.ok(podcastDTO);
  }

  Podcast createPodcast(PodcastCreationDTO newPodcast) {
    Podcast podcast = new Podcast();
    podcast.setId(new Random().nextInt(0, 1000));
    podcast.setSecretToker("super-secret-toukhen");
    podcast.setName(newPodcast.name());
    podcast.setUrl(newPodcast.url());

    return podcast;
  }

  @PostMapping
  public ResponseEntity<PodcastDTO> newPodcast(@RequestBody PodcastCreationDTO newPodcast) {
    Podcast podcast = createPodcast(newPodcast);

    PodcastDTO podcastDTO = new PodcastDTO(podcast.getId(), podcast.getName(), podcast.getUrl());
    return ResponseEntity.status(HttpStatus.CREATED).body(podcastDTO);
  }

  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return String.format("Você procurou pelo podcast: %s", title);
  }  
}

