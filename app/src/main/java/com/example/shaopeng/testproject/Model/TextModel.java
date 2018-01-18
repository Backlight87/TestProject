package com.example.shaopeng.testproject.Model;

import java.util.List;

/**
 * Created by Administrator on 2017/11/24.
 */
public class TextModel {
    /**
     * result_code : 1000
     * result_msg :
     * data : {"page":1,"size":10,"total_pages":1,"total_result":6,"rows":[{"id":7,"name":"虚拟商品","price":233,"integral":200,"deduct":0,"points":0,"first_image":"images/goods/86ea4aab7da84924a4c9da9b59a0169c.png"},{"id":10024,"name":"香蕉","price":10,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/261bb622c8dc4c628a4bdbebec2f62a8.png"},{"id":10025,"name":"香蕉","price":10,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/485563002c0c4328ab46a6b3b7387b26.png"},{"id":10026,"name":"香蕉","price":10,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/57b5362d0d374a61801766cb977051f0.png"},{"id":10027,"name":"赏你花","price":20,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/e6b8527d6f254f09bd72b986f592be56.png"},{"id":10028,"name":"苹果","price":10,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/8b2ed837a33b4a63a38bc16099607974.png"}]}
     */

    private int result_code;
    private String result_msg;
    private DataBean data;

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * page : 1
         * size : 10
         * total_pages : 1
         * total_result : 6
         * rows : [{"id":7,"name":"虚拟商品","price":233,"integral":200,"deduct":0,"points":0,"first_image":"images/goods/86ea4aab7da84924a4c9da9b59a0169c.png"},{"id":10024,"name":"香蕉","price":10,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/261bb622c8dc4c628a4bdbebec2f62a8.png"},{"id":10025,"name":"香蕉","price":10,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/485563002c0c4328ab46a6b3b7387b26.png"},{"id":10026,"name":"香蕉","price":10,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/57b5362d0d374a61801766cb977051f0.png"},{"id":10027,"name":"赏你花","price":20,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/e6b8527d6f254f09bd72b986f592be56.png"},{"id":10028,"name":"苹果","price":10,"integral":0,"deduct":0,"points":0,"first_image":"goods/15064976206925378/8b2ed837a33b4a63a38bc16099607974.png"}]
         */

        private int page;
        private int size;
        private int total_pages;
        private int total_result;
        private List<RowsBean> rows;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public int getTotal_result() {
            return total_result;
        }

        public void setTotal_result(int total_result) {
            this.total_result = total_result;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * id : 7
             * name : 虚拟商品
             * price : 233.0
             * integral : 200
             * deduct : 0.0
             * points : 0.0
             * first_image : images/goods/86ea4aab7da84924a4c9da9b59a0169c.png
             */

            private int id;
            private String name;
            private double price;
            private int integral;
            private double deduct;
            private double points;
            private String first_image;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public double getDeduct() {
                return deduct;
            }

            public void setDeduct(double deduct) {
                this.deduct = deduct;
            }

            public double getPoints() {
                return points;
            }

            public void setPoints(double points) {
                this.points = points;
            }

            public String getFirst_image() {
                return first_image;
            }

            public void setFirst_image(String first_image) {
                this.first_image = first_image;
            }
        }
    }
}
