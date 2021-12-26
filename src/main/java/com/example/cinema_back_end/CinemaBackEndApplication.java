package com.example.cinema_back_end;

import com.example.cinema_back_end.entities.Movie;
import com.example.cinema_back_end.repositories.IMovieRepository;
import com.example.cinema_back_end.entities.Role;
import com.example.cinema_back_end.entities.User;
import com.example.cinema_back_end.security.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class CinemaBackEndApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Autowired
    private IUserService userService;

    @Autowired
    private IMovieRepository movieRepository;

    @PostConstruct
    public void init() {
        List<User> users = userService.findAll();

        if (users.isEmpty()) {
            User admin = new User();
            Set<Role> roles = new HashSet<>();
            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_CLIENT");
            roles.add(roleAdmin);
            admin.setFullName("Cong Huy");
            admin.setUsername("huync21@gmail.com");
            admin.setPassword("123");
            admin.setRoles(roles);
            userService.save(admin);
        }

        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


            addNewMovie("Nhóc Trùm: Nối Nghiệp Gia Đình","https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_boss_baby_2_24.12.2021_1_1_1__1.jpg",
                    "Nhóc trùm Ted giờ đây đã trở thành một triệu phú nổi tiếng trong khi Tim lại có một cuộc sống đơn giản bên vợ anh Carol và hai cô con gái nhỏ yêu dấu. Mỗi mùa Giáng sinh tới, cả Tina và Tabitha đều mong được gặp chú Ted",
                    "Nhóc trùm Ted giờ đây đã trở thành một triệu phú nổi tiếng trong khi Tim lại có một cuộc sống đơn giản bên vợ anh Carol và hai cô con gái nhỏ yêu dấu. Mỗi mùa Giáng sinh tới, cả Tina và Tabitha đều mong được gặp chú Ted nhưng dường như hai anh em nhà Templeton nay đã không còn gần gũi như xưa. Nhưng bất ngờ thay khi Ted lại có màn tái xuất không thể hoành tráng hơn khi đáp thẳng máy bay trực thăng tới nhà Tim trước sự ngỡ ngàng của cả gia đình.",
                    "https://scontent-sin6-3.xx.fbcdn.net/v/t1.15752-9/266631693_4703963403044964_3186366444621545031_n.png?_nc_cat=104&ccb=1-5&_nc_sid=ae9488&_nc_ohc=PZUaW3ze910AX_dCmWG&tn=1IgLGfjKXU7KNzCP&_nc_ht=scontent-sin6-3.xx&oh=03_AVJib4-shv17dFXIA2l2TVbTcYez_uxoolsNlRFERG7z4w&oe=61E9DEA1",
                    "Tom McGrath","Amy Sedaris, Jeff Goldblum, James Marsden",
                    "Hoạt Hình",LocalDate.parse("24/12/2021",formatter),
                    105,"https://www.youtube.com/watch?v=Lv8nL2q8yRI",
                    "Tiếng Anh với phụ đề tiếng Việt và lồng tiếng Việt",
                    "P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG",1);



            addNewMovie("Venom: Đối Mặt Tử Thù","https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_venom_121121_1__1.jpg",
                    "Siêu bom tấn #VENOM: LET THERE BE CARNAGE hứa hẹn trận chiến khốc liệt nhất giữa Venom và kẻ thù truyền kiếp, Carnage.",
                    "Siêu bom tấn #VENOM: LET THERE BE CARNAGE hứa hẹn trận chiến khốc liệt nhất giữa Venom và kẻ thù truyền kiếp, Carnage.",
                    "https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg",
                    "Andy Serkis","Tom Hardy, Michelle Williams, Woody Harrelson, Naomie Harris",
                    "Hành Động, Khoa Học Viễn Tưởng, Phiêu Lưu, Thần thoại",
                    LocalDate.parse("10/12/2021",formatter),97,"https://www.youtube.com/watch?v=EVWdzVtSh1I",
                    "Tiếng Anh - Phụ đề Tiếng Việt","C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI",1);
            addNewMovie("Ma Trận: Hồi Sinh","https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_matrix_4_1__1.jpg",
                    "Sau 20 năm, siêu phẩm ma trận đã trờ lại với người xem, Neo is back! Liệu đây có phải phần kết cho franchise này",
                    "Ma Trận: Hồi Sinh là phần phim tiếp theo rất được trông đợi của loạt phim “Ma Trận” đình đám, đã góp phần tái định nghĩa thể loại phim khoa học viễn tưởng. Phần phim mới nhất này đón chào sự trở lại của cặp đôi Keanu Reeves và Carrie-Anne Moss với vai diễn biểu tượng đã làm nên tên tuổi của họ, Neo và Trinity. Ngoài ra, phim còn có sự góp mặt của dàn diễn viên đầy tài năng gồm Yahya Abdul-Mateen II, Jessica Henwick, Jonathan Groff, Neil Patrick Harris, Priyanka Chopra Jonas và Christina Ricci.",
                    "https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg",
                    "Lana Wachowski","Keanu Reeves, Carrie-Anne Moss, Yahya Abdul-Mateen II, Jessica Henwick, Jonathan Groff, Neil Patrick Harris, Priyanka Chopra Jonas và Christina Ricci",
                    "Hành Động, Khoa Học Viễn Tưởng",LocalDate.parse("24/12/2021",formatter),
                    148,"https://www.youtube.com/watch?v=l2UTOJC5Tbk",
                    "Tiếng Anh - Phụ đề Tiếng Việt, Phụ đề Tiếng Hàn",
                    "C18 - PHIM CẤM KHÁN GIẢ DƯỚI 18 TUỔI",1);
            addNewMovie("Doraemon: Ôi Bạn Ơi 2","https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_doremon_2_1__1.jpg",
                    "Một ngày nọ, Nobita vô tình tìm thấy chú gấu bông cũ, món đồ chơi chất chứa bao kỉ niệm cùng người bà đáng kính. Với khát khao “muốn gặp bà lần nữa”, Nobita đã trở về quá khứ bằng cổ máy thời gian, bất chấp sự phản đối của Doraemon",
                    "Một ngày nọ, Nobita vô tình tìm thấy chú gấu bông cũ, món đồ chơi chất chứa bao kỉ niệm cùng người bà đáng kính. Với khát khao “muốn gặp bà lần nữa”, Nobita đã trở về quá khứ bằng cổ máy thời gian, bất chấp sự phản đối của Doraemon. Dù ngạc nhiên, bà vẫn tin cậu thiếu niên lớn tướng trước mặt mình là cháu mình. Trước nguyện vọng tha thiết “mong được thấy cháu dâu một lần”, chuyến phiêu lưu của Doraemon và Nobita bắt đầu. Nobita muốn cho bà xem đám cưới của mình, nhưng đúng ngày thành hôn với Shizuka, chú rể Nobita lại trốn mất? Jaian và Suneo chạy đôn chạy đáo tìm bạn, còn Shizuka vẫn tin tưởng chờ đợi Nobita. Để thực hiện nguyện vọng của bà, đáp lại niềm tin của gia đình, bạn bà và Shizuka yêu quý, Nobita sẽ cùng Doraemon du hành vượt thời gian. Họ sẽ mang đến cho chúng ta một câu chuyện cảm động đến rơi lệ về quan hệ con người, kết nối giữa quá khứ, hiện tại và tương lai.",
                    "https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/d/o/doreamon.jpg","Ryuichi Yagi, Takashi Yamazaki",
                    "Wasabi Mizuta, Megumi Oohara, Yumi Kakazu, Subaru Kimura, Tomokazu Seki",
                    "Hài, Hoạt Hình",LocalDate.parse("17/12/2021",formatter),
                    96,"https://youtu.be/GXnOs4Hj8MA","Tiếng Nhật - Phụ đề Tiếng Việt; Lồng tiếng",
                    "P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG",1);
            addNewMovie("Câu Chuyện Phía Tây","https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_wss_1200x1800__1.jpg",
                    "“Câu chuyện phía Tây” kể lại câu chuyện tình yêu kinh điển của Tony và Maria, giữa sự giằng xé của tình yêu trẻ tuổi và sự ngăn cấm, thù hằn ở thành phố NewYork những năm 1950",
                    "Được đạo diễn bởi đạo diễn gạo cội từng giành giải Oscar Steven Spielberg, cùng kịch bản bởi biên kịch từng giành giải Pulitzer Prize và giải Tony Award, Tony Kushner, “Câu chuyện phía Tây” kể lại câu chuyện tình yêu kinh điển của Tony và Maria, giữa sự giằng xé của tình yêu trẻ tuổi và sự ngăn cấm, thù hằn ở thành phố NewYork những năm 1950.",
                    "https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/w/s/wss_sneak_980x448.jpg",
                    "Steven Spielberg","Ansel Elgort, Rachel Zegler, Ariana DeBose, David Alvarez, Mike Faist, Josh Andrés Rivera, Ana Isabelle, Corey Stoll, Brian d’Arcy James, Rita Moreno",
                    "Nhạc kịch, Tình cảm",LocalDate.parse("24/12/2021",formatter),
                    156,"https://www.youtube.com/watch?v=QPvqV71P0Fo","Tiếng Anh - Phụ đề Tiếng Việt",
                    "C16 - PHIM CẤM KHÁN GIẢ DƯỚI 16 TUỔI",1);

            addNewMovie("BlackPink The Movie","https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_blackpink_vie_2_1__1.jpg",
                    "Nhóm nhạc nữ được yêu thích toàn cầu, BLACKPINK sẽ kỷ niệm năm thứ 5 hoạt động của nhóm với việc phát hành BLACKPINK THE MOVIE",
                    "Nhóm nhạc nữ được yêu thích toàn cầu, BLACKPINK sẽ kỷ niệm năm thứ 5 hoạt động của nhóm với việc phát hành BLACKPINK THE MOVIE, đây cũng như là món quà đặc biệt dành tặng cho các BLINK— fandom của BLACKPINK — bộ phim sẽ tái hiện một cách sống động những kỷ niệm không thể quên cùng những màn trinh diễn đầy cuồng nhiệt đúng tinh thần lễ hội.",
                    "https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg",
                    "Su Yee Jung, Oh Yoon-Dong","JISOO, JENNIE, ROSÉ, LISA",
                    "Phim tài liệu",LocalDate.parse("24/12/2021",formatter),99,
                    "https://www.youtube.com/watch?v=Q_rK9UlUN-Q","Tiếng Hàn - Phụ đề tiếng Việt",
                    "P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG",1);
            addNewMovie("Người Nhện: Không Còn Nhà","https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/s/n/snwh_poster_bluemontage_4x5fb_1__1.jpg"
                    ,"Đa vũ trụ được mở ra, những kẻ phản diện nào sẽ trạm chán spidey, cùng đón xem nhá",
                    "Lần đầu tiên trong lịch sử điện ảnh của Người Nhện, thân phận người hàng xóm thân thiện bị lật mở, khiến trách nhiệm làm một Siêu Anh Hùng xung đột với cuộc sống bình thường và đặt người anh quan tâm nhất vào tình thế nguy hiểm. Khi anh nhờ đến giúp đỡ của Doctor Strange để khôi phục lại bí mật, phép thuật đã gây ra lỗ hổng thời không, giải phóng những ác nhân mạnh mẽ nhất từng đối đầu với Người Nhện từ mọi vũ trụ. Bây giờ, Peter sẽ phải vượt qua thử thách lớn nhất của mình, nó sẽ thay đổi không chỉ tương lai của chính anh mà còn là tương lai của cả Đa Vũ Trụ."
                    ,"https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/262340222_703558363874342_7416936818287635017_n.png?_nc_cat=108&ccb=1-5&_nc_sid=ae9488&_nc_ohc=kgxsskqjaGMAX-fvrSm&_nc_ht=scontent-sin6-2.xx&oh=03_AVI4rg87OK9nazDSK_CvkOQobdA9iqv9SQW2-HA54qEKWg&oe=61ECC9EE",
                    "Jon Watts","Tom Holland, Zendaya, Benedict Cumberbatch, Jacob Batalon, Jon Favreau","Hành Động, Phiêu Lưu",
                    LocalDate.parse("17/12/2021",formatter),
                    149,"https://www.youtube.com/watch?v=daHCu_jU5mQ",
                    "Tiếng Anh - Phụ đề Tiếng Việt",
                    "C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI",1);
        }


    }

    public void addNewMovie(
            String name,
            String smallImageURl,
            String shortDescription,
            String longDescription,
            String largeImageURL,
            String director,
            String actors,
            String categories,
            LocalDate releaseDate,
            int duration,
            String trailerURL,
            String language,
            String rated,
            int isShowing) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setSmallImageURl(smallImageURl);
        movie.setShortDescription(shortDescription);
        movie.setLongDescription(longDescription);
        movie.setLargeImageURL(largeImageURL);
        movie.setDirector(director);
        movie.setActors(actors);
        movie.setCategories(categories);
        movie.setReleaseDate(releaseDate);
        movie.setDuration(duration);
        movie.setTrailerURL(trailerURL);
        movie.setLanguage(language);
        movie.setRated(rated);
        movie.setIsShowing(isShowing);
        movieRepository.save(movie);

    }

    public static void main(String[] args) {
        SpringApplication.run(CinemaBackEndApplication.class, args);
    }

}
