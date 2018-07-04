package com.zcl.alive.model.bean.movies;

import java.io.Serializable;
import java.util.List;

public class MovieInfo implements Serializable {

    /**
     * rating : {"max":10,"average":4.9,"stars":"25","min":0}
     * genres : ["动作","奇幻","冒险"]
     * title : 长城
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054443/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp"},"name":"马特·达蒙","id":"1054443"},{"alt":"https://movie.douban.com/celebrity/1275432/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1407683852.1.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1407683852.1.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1407683852.1.webp"},"name":"景甜","id":"1275432"},{"alt":"https://movie.douban.com/celebrity/1329628/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1397806328.94.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1397806328.94.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1397806328.94.webp"},"name":"佩德罗·帕斯卡","id":"1329628"}]
     * collect_count : 260778
     * original_title : The Great Wall
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1054398/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp"},"name":"张艺谋","id":"1054398"}]
     * year : 2016
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2394573821.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2394573821.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2394573821.webp"}
     * alt : https://movie.douban.com/subject/6982558/
     * id : 6982558
     */

    private RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 4.9
         * stars : 25
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2394573821.webp
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2394573821.webp
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2394573821.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1054443/
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp"}
         * name : 马特·达蒙
         * id : 1054443
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p620.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1054398/
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp"}
         * name : 张艺谋
         * id : 1054398
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
