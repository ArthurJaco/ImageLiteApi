package io.github.arthurgoat.imageliteapi;

import io.github.arthurgoat.imageliteapi.domain.entity.Image;
import io.github.arthurgoat.imageliteapi.domain.enums.ImageExtension;
import io.github.arthurgoat.imageliteapi.infra.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class ImageliteapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageliteapiApplication.class, args);
	}

}
