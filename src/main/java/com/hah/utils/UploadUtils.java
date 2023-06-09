package com.hah.utils;

import com.cloudinary.utils.ObjectUtils;
import com.hah.exception.DataInputException;
import com.hah.model.News;
import com.hah.model.NewsImage;
import com.hah.model.Product;
import com.hah.model.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UploadUtils {
    public static final String IMAGE_UPLOAD_FOLDER_PRODUCT = "emart_product_images";
    public static final String IMAGE_UPLOAD_FOLDER_USER = "emart_user_images";
    public static final String DEFAULT_USER_AVATAR_IMAGE = "user_default.png";
    public static final String DEFAULT_USER_AVATAR_URL = "https://res.cloudinary.com/smeenguyen/image/upload/v1677305020/emart_user_images/user_default.png";
    public static final String DEFAULT_USER_AVATAR_CLOUD_ID = "emart_user_images/user_default";

//    public Map buildImageUploadParamsProduct(ProductAvatar productAvatar) {
//        if (productAvatar == null || productAvatar.getId() == null)
//            throw new DataInputException("Không thể upload hình ảnh của sản phẩm chưa được lưu");
//
//        String publicId = String.format("%s/%s", IMAGE_UPLOAD_FOLDER_PRODUCT, productAvatar.getId());
//
//        return ObjectUtils.asMap(
//                "public_id", publicId,
//                "overwrite", true,
//                "resource_type", "image"
//        );
//    }
//
//    public Map buildImageDestroyParams(Product product, String publicId) {
//        if (product == null || product.getId() == null)
//            throw new DataInputException("Không thể destroy hình ảnh của sản phẩm không xác định");
//
//        return ObjectUtils.asMap(
//                "public_id", publicId,
//                "overwrite", true,
//                "resource_type", "image"
//        );
//    }

    public Map buildNewsImageUploadParams(NewsImage newsImage) {
        if (newsImage == null || newsImage.getId() == null)
            throw new DataInputException("Không thể upload hình ảnh của sản phẩm chưa được lưu");

        String publicId = String.format("%s/%s", IMAGE_UPLOAD_FOLDER_USER, newsImage.getId());

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }

    public Map buildNewsImageDestroyParams(News news, String publicId) {
        if (news == null || news.getId() == null)
            throw new DataInputException("Không thể destroy hình ảnh của sản phẩm không xác định");

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }
}
