package com.aster.podcastManager;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/podcasts")
public class PodcastRestController {
  @GetMapping
  public String getRoot() {
    return "Yay podcasts!";
  }

  @GetMapping("/{id}")
  public ResponseEntity<Podcast> getPodcast(@PathVariable Integer id) {
    if (id > 1000) 
      return ResponseEntity.notFound().build();

    Podcast result = new Podcast();
    result.setId(id);
    result.setName("Meu podcast");
    result.setUrl("https://www.meupodcast.com.br/");
    // return String.format("Você pediu pelo podcast com id: %d", id);
    return ResponseEntity.ok(result);
  }
  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return String.format("Você procurou pelo podcast: %s", title);
  }
}
