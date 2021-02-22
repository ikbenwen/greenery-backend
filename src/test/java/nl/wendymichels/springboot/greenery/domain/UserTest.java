package nl.wendymichels.springboot.greenery.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Test
    public void usernameShouldBeSaved(){
        User user = new User();
        user.setUsername("Wendy");
        assertEquals("Wendy", user.getUsername());
    }

    @Test
    public void EmailShouldBeSaved(){
        User user = new User();
        user.setEmail("wendy@gmail.com");
        assertEquals("wendy@gmail.com", user.getEmail());
    }

    @Test
    public void PasswordShouldBeSaved(){
        User user = new User();
        user.setPassword("supersecret");
        assertEquals("supersecret", user.getPassword());
    }

    @Test
    public void AvatarShouldBeSaved(){
        User user = new User();
        user.setAvatar("https://images.squarespace-cdn.com/content/v1/54d23745e4b081a6640ace91/1478189045633-ZFXP0Q2WHCTUH0AQL2B9/ke17ZwdGBToddI8pDm48kLdFCuCuKl5PjBGagdvc2GF7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UboBw5gxpdJeqDIQH2IfKCr_csUssBBf_rBe5nKd3NsMQlwWNyQzJWsQ2DblaEcfPw/image-asset.jpeg");
        assertEquals("https://images.squarespace-cdn.com/content/v1/54d23745e4b081a6640ace91/1478189045633-ZFXP0Q2WHCTUH0AQL2B9/ke17ZwdGBToddI8pDm48kLdFCuCuKl5PjBGagdvc2GF7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UboBw5gxpdJeqDIQH2IfKCr_csUssBBf_rBe5nKd3NsMQlwWNyQzJWsQ2DblaEcfPw/image-asset.jpeg", user.getAvatar());
    }
}
