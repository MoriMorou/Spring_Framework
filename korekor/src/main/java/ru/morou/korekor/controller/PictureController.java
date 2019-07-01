package ru.morou.korekor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.morou.korekor.aspect.TrackTime;
import ru.morou.korekor.persist.model.Picture;
import ru.morou.korekor.persist.repo.PictureRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Controller
public class PictureController {

    /**
     *  Классический вариан логирования, а можно по другому https://habr.com/ru/post/276729/
     */
    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    private final PictureRepository pictureRepository;

    public PictureController(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @TrackTime
    @GetMapping("/picture/{pictureId}")
    public void adminDownloadProductPicture(@PathVariable("pictureId") Long pictureId,
                                            HttpServletResponse response) throws IOException {
        logger.info("Picture {}", pictureId);
        Optional<Picture> picture = pictureRepository.findById(pictureId);
        if (picture.isPresent()) {
            response.setContentType(picture.get().getContentType());
            response.getOutputStream().write(picture.get().getPictureData().getData());
        }
    }
}
