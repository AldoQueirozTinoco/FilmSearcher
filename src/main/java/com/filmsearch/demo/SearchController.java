package com.filmsearch.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;


@Controller
public class SearchController {

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/")
    public String greeting(Model model){
        Film film = new Film();
        model.addAttribute("movie",film);
        return "search";
    }

    @GetMapping("/search")
    public String movieInfo(@RequestParam("Title") String movieName, Model model){
        String url = "http://www.omdbapi.com/?apikey="+apiKey+"&t=" + movieName;

        WebClient.Builder builder = WebClient.builder();

        Film movie = builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Film.class)
                .block();


        if (movie != null) {
            model.addAttribute("movie", movie);
        } else {
            model.addAttribute("movie", new Film());
        }

        return "searchResult";

    }

}
