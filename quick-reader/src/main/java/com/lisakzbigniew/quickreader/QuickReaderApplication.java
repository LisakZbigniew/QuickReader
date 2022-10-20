package com.lisakzbigniew.quickreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.lisakzbigniew.quickreader.gui.QuickReaderFrame;

import java.awt.EventQueue;

@SpringBootApplication
public class QuickReaderApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(QuickReaderApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);

		EventQueue.invokeLater(() -> {

            var ex = context.getBean(QuickReaderFrame.class);
            ex.setVisible(true);
        });
	}

}
