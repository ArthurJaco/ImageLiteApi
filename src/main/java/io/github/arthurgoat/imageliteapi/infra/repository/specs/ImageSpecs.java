package io.github.arthurgoat.imageliteapi.infra.repository.specs;

import io.github.arthurgoat.imageliteapi.domain.entity.Image;
import io.github.arthurgoat.imageliteapi.domain.enums.ImageExtension;
import org.springframework.data.jpa.domain.Specification;

public class ImageSpecs {
    private ImageSpecs() {}

    public static Specification<Image> extensionEqual(ImageExtension extension){
       return  (root, q, cB) -> cB
                .equal(root.get("extension"), extension);
    }

    public static Specification<Image> nameLike(String name){
        return (root, q, cB) -> cB
                .like(cB.upper(root.get("name")), "%" + name.toUpperCase() + "%");

    }

    public static Specification<Image> tagsLike(String tags){
        return (root, q, cB) -> cB
                .like(cB.upper(root.get("tags")), "%" + tags.toUpperCase() + "%");

    }

}
