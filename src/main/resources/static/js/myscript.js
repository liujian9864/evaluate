/**
 * Created by Intellij IDEA.
 * @Author LUOLIANG
 * @Date 2016/8/2
 * @Comment js文件，用于页面发送ajax请求
 */

//定义一个avalonjs的控制器
var viewmodel = avalon.define({
    //id必须和页面上定义的ms-controller名字相同，否则无法控制页面
    $id: "viewmodel",
    datalist: {},
    text: "请求数据",
    delete:"×",
    update:"modify",
    request: function () {
        $.ajax({
            type: "post",
            url: "/dialog/data",    //向springboot请求数据的url
            data: {},
            success: function (result) {
                $('button').removeClass("btn-primary").addClass("btn-success").attr('disabled', true);

                viewmodel.datalist = result;

                viewmodel.text = "数据请求成功，已渲染";

            }
        });
    },
    deleteOne: function () {
        $.ajax({
            type: "post",
            url: "/dialog/deleteLawById",    //向springboot请求数据的url
            data: {},
            success: function (result) {
                $('button').removeClass("btn-primary").addClass("btn-success").attr('disabled', true);

                viewmodel.datalist = result;

                viewmodel.text = "数据请求成功，已渲染";

            }
        });
    },

});