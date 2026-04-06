package com.example;

import com.example.model.Place;
import com.example.repository.PlaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final PlaceRepository placeRepository;

    public Main(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        Place destination1 = new Place(
                "Санторіні",
                "Мальовничий грецький острів з білими будинками на скелях та неймовірними заходами сонця.",
                "https://tripmydream.cc/travelhub/travel/block_gallery/11/4343/default_114343.jpg?"
        );

        Place destination2 = new Place(
                "Рим",
                "Рим — столиця Італії з багатою історією, Колізеєм та Ватиканом.",
                "https://media.tacdn.com/media/attractions-splice-spp-674x446/15/73/ca/eb.jpg"
        );

        Place destination3 = new Place(
                "Хургада",
                "Піщані пляжі, Червоне море, готелі на узбережжі та водні розваги.",
                "https://www.kidpassage.com/images/resorts/images/hurgada-05.jpg"
        );

        placeRepository.save(destination1);
        placeRepository.save(destination2);
        placeRepository.save(destination3);

        System.out.println("Туристичні місця додано: " + destination1 + ", " + destination2+ ", " + destination3);

        List<Place> destinations = placeRepository.findAll();
        System.out.println("Список туристичних місць: " + destinations);

    }
}
