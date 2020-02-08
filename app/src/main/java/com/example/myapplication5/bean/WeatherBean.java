package com.example.myapplication5.bean;

import java.util.List;

public class WeatherBean {

    /**
     * error : 0
     * status : success
     * date : 2020-02-02
     * results : [{"currentCity":"北京","pm25":"23","index":[{"des":"天气寒冷，建议着厚羽绒服、毛皮大衣加厚毛衣等隆冬服装。年老体弱者尤其要注意保暖防冻。","tipt":"穿衣指数","title":"穿衣","zs":"寒冷"},{"des":"不宜洗车，未来24小时内有雪，如果在此期间洗车，雪水和路上的泥水可能会再次弄脏您的爱车。","tipt":"洗车指数","title":"洗车","zs":"不宜"},{"des":"天冷，发生感冒机率较大，请注意适当增加衣服，加强自我防护避免感冒。","tipt":"感冒指数","title":"感冒","zs":"易发"},{"des":"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意保暖，做好准备活动，携带雨具。","tipt":"运动指数","title":"运动","zs":"较不宜"},{"des":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。","tipt":"紫外线强度指数","title":"紫外线强度","zs":"最弱"}],"weather_data":[{"date":"周日 02月02日 (实时：2℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoxue.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"小雪转晴","wind":"东北风微风","temperature":"3 ~ -7℃"},{"date":"周一","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"西南风3-4级","temperature":"3 ~ -6℃"},{"date":"周二","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"晴转多云","wind":"东北风3-4级","temperature":"3 ~ -8℃"},{"date":"周三","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/yin.png","weather":"多云转阴","wind":"东南风微风","temperature":"-1 ~ -7℃"}]}]
     */

    private int error;
    private String status;
    private String date;
    private List<ResultsBean> results;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * currentCity : 北京
         * pm25 : 23
         * index : [{"des":"天气寒冷，建议着厚羽绒服、毛皮大衣加厚毛衣等隆冬服装。年老体弱者尤其要注意保暖防冻。","tipt":"穿衣指数","title":"穿衣","zs":"寒冷"},{"des":"不宜洗车，未来24小时内有雪，如果在此期间洗车，雪水和路上的泥水可能会再次弄脏您的爱车。","tipt":"洗车指数","title":"洗车","zs":"不宜"},{"des":"天冷，发生感冒机率较大，请注意适当增加衣服，加强自我防护避免感冒。","tipt":"感冒指数","title":"感冒","zs":"易发"},{"des":"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意保暖，做好准备活动，携带雨具。","tipt":"运动指数","title":"运动","zs":"较不宜"},{"des":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。","tipt":"紫外线强度指数","title":"紫外线强度","zs":"最弱"}]
         * weather_data : [{"date":"周日 02月02日 (实时：2℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoxue.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"小雪转晴","wind":"东北风微风","temperature":"3 ~ -7℃"},{"date":"周一","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"西南风3-4级","temperature":"3 ~ -6℃"},{"date":"周二","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"晴转多云","wind":"东北风3-4级","temperature":"3 ~ -8℃"},{"date":"周三","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/yin.png","weather":"多云转阴","wind":"东南风微风","temperature":"-1 ~ -7℃"}]
         */

        private String currentCity;
        private String pm25;
        private List<IndexBean> index;
        private List<WeatherDataBean> weather_data;

        public String getCurrentCity() {
            return currentCity;
        }

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public List<IndexBean> getIndex() {
            return index;
        }

        public void setIndex(List<IndexBean> index) {
            this.index = index;
        }

        public List<WeatherDataBean> getWeather_data() {
            return weather_data;
        }

        public void setWeather_data(List<WeatherDataBean> weather_data) {
            this.weather_data = weather_data;
        }

        public static class IndexBean {
            /**
             * des : 天气寒冷，建议着厚羽绒服、毛皮大衣加厚毛衣等隆冬服装。年老体弱者尤其要注意保暖防冻。
             * tipt : 穿衣指数
             * title : 穿衣
             * zs : 寒冷
             */

            private String des;
            private String tipt;
            private String title;
            private String zs;

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getTipt() {
                return tipt;
            }

            public void setTipt(String tipt) {
                this.tipt = tipt;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getZs() {
                return zs;
            }

            public void setZs(String zs) {
                this.zs = zs;
            }
        }

        public static class WeatherDataBean {
            /**
             * date : 周日 02月02日 (实时：2℃)
             * dayPictureUrl : http://api.map.baidu.com/images/weather/day/xiaoxue.png
             * nightPictureUrl : http://api.map.baidu.com/images/weather/night/qing.png
             * weather : 小雪转晴
             * wind : 东北风微风
             * temperature : 3 ~ -7℃
             */

            private String date;
            private String dayPictureUrl;
            private String nightPictureUrl;
            private String weather;
            private String wind;
            private String temperature;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDayPictureUrl() {
                return dayPictureUrl;
            }

            public void setDayPictureUrl(String dayPictureUrl) {
                this.dayPictureUrl = dayPictureUrl;
            }

            public String getNightPictureUrl() {
                return nightPictureUrl;
            }

            public void setNightPictureUrl(String nightPictureUrl) {
                this.nightPictureUrl = nightPictureUrl;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }
        }
    }
}
