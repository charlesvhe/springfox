package com.github.charlesvhe.springfox.demo.pojo;

public interface Group {
    interface Crud extends Group {
        /**
         * 添加入参
         */
        interface Create extends Crud {
        }
        /**
         * 查询入参
         */
        interface Retrieve extends Crud {
        }
        /**
         * 修改入参
         */
        interface Update extends Crud {
        }
        /**
         * 删除入参
         */
        interface Delete extends Crud {
        }
        /**
         * 查询返回一般信息
         */
        interface General extends Crud {
        }
        /**
         * 查询返回详细信息
         */
        interface Detail extends Crud {
        }
        /**
         * 预留A
         */
        interface CrudA extends Crud {
        }
        /**
         * 预留B
         */
        interface CrudB extends Crud {
        }
        /**
         * 预留C
         */
        interface CrudC extends Crud {
        }
    }
}
