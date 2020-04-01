function Tabs(tabs_name, contents_name, tabs_checked_style, contents_checked_style) {
    var tabs = document.querySelectorAll(tabs_name),
        contents = document.querySelectorAll(contents_name),
        e_mark = 0;
    for (var i = 0, len = tabs.length; i < len; i++) {
        tabs[i].num = i;
        tabs[i].onclick = function () {
            tabs[e_mark].classList.toggle(tabs_checked_style);
            tabs[this.num].classList.toggle(tabs_checked_style);
            contents[e_mark].classList.toggle(contents_checked_style);
            contents[this.num].classList.toggle(contents_checked_style);
            e_mark = this.num;
        };
    }
}

 $(function() {
        showAllByPage(1);
        function showAllByPage(currentPage) {

            var stuNumberId=$("#numberId").val();
            var stuName=$("#name").val();
            var stuInstitution=$("#institution").val();
            var stuClass=$("#class").val();
            var search = $("#search").val();
            $.ajax({
                type: "post",
                url: "/loginUser",
                dataType: "json",
                success:function (result){
                    var user=result.userName+"("+result.userType+")"
                    $('#loginuser').html(user);
                    $('#admin').html(result.userName);

                }
            })
            $.ajax({
                type: "post",
                url: "/admin/allstudent",
                data: {currentPage:currentPage,stuNumberId:stuNumberId,stuName:stuName,stuInstitution:stuInstitution,stuClass:stuClass},
                dataType: "json",
                success: function (result) {
                    var totalPage = result.totalPage;
                    var currentPage = result.currentPage;

                    var tbody = "";
                    for (i = 0; i <  result.students.length; i++) {
                        var tr = "";
                        tr += "<tr>";
                        tr += "<td>" + result.students[i].stuNumberId + "</td>";
                        tr += "<td>" + result.students[i].stuName + "</td>";
                        tr += "<td>" + result.students[i].stuSex + "</td>";
                        tr += "<td>" + result.students[i].stuInstitution + "</td>";
                        tr += "<td>" + result.students[i].stuClass + "</td>";
                        tr += "<td><button value='" + result.students[i].stuId + "' type='button' class='btn btn-primary modButton modstudent'>修改</button> <button value='" + result.students[i].stuId + "' type='button' class='btn btn-danger delButton delstudent' title='删除用户'>删除</button></td>"
                        tr += "</tr>";
                        tbody += tr;
                    }
                    $("#studentbody").html(tbody);

                    var ul = "";
                    for(i=1;i<=totalPage;i++){
                        var li = "";
                        li += "<li class='fenli fenli1'><a class='fenye fenye1' id='numberPage1'>"+i+"</a></li>";
                        ul += li;
                    }
                    var uli =""
                    uli += "<li><a class='fenye fenye1' id='previousPage1'>«</a></li>";
                    uli += ul;
                    uli += "<li><a class='fenye fenye1' id='nextPage1'>»</a></li>";
                        $("#showAllLawFenye").html(uli);

                    $(".fenye1").unbind("click");
                    $(".fenye1").click(function(){
                        var id = $(this).attr("id");
                        if(id == "previousPage1"){
                            if(currentPage == 1){
                                alert("已经第一页了");
                            }else{
                                showAllByPage(currentPage-1);
                            }
                        }else if(id == "nextPage1"){
                            if(currentPage == totalPage){
                                alert("已经是最后一页了");
                            }else{
                                showAllByPage(currentPage+1);
                            }
                        }else if(id == "numberPage1"){
                            showAllByPage($(this).text());
                        }
                    })
                    var number = currentPage-1;
                    $(".fenli1:eq("+number+")").attr("class","am-active");

                    $("#searchLawByName").unbind("click");
                    $("#searchLawByName").click(function(){
                        showAllByPage(1);
                    })

                    $(".delstudent").unbind("click");
                    $(".delstudent").click(function(){
                        var msg = "您真的确定要删除吗？\n\n请确认！";
                        if (confirm(msg)==true){
                        var stuId = $(this).val();
                        $.ajax({
                            type: "post",
                            url: "/admin/deleteStudentById",
                            data: {stuId:stuId},
                            dataType: "json",
                            success:showAllByPage(1)
                        })
                            alert("删除成功")
                        }else{

                        }
                    })

                    $(".modstudent").unbind("click");
                    $(".modstudent").click(function(){
                        $('#content-box').css('display', 'none');
                        popCenterWindow();
                        var stuId = $(this).val();
                        $.ajax({
                            type: "post",
                            url: "/admin/selectStudentById",
                            data: {stuId:stuId},
                            dataType: "json",
                            success:function (result) {
                                $('#stuId').val(result.stuId);
                                $('#stuNumberId').val(result.stuNumberId);
                                $('#stuName').val(result.stuName);
                                if (result.stuSex=='男'){
                                    $("input[name='sex'][value='男']").attr("checked",true);
                                }else {
                                    $("input[name='sex'][value='女']").attr("checked",true);
                                }
                                $("#stuInstitution ").val(result.stuInstitution);
                                $('#stuClass').val(result.stuClass);
                            }
                        });
                    })



                    //获取窗口的高度
                    var windowHeight;
                    //获取窗口的宽度
                    var windowWidth;
                    //获取弹窗的宽度
                    var popWidth;
                    //获取弹窗高度
                    var popHeight;

                    function init() {
                        windowHeight = $(window).height();
                        windowWidth = $(window).width();
                        popHeight = $(".edit_student").height();
                        popWidth = $(".edit_student").width();
                    }
                    //关闭窗口的方法
                    function closeWindow() {
                        $("#close").click(function () {
                            $('.edit_student').hide(1);
                            $('#content-box').css('display', 'block');
                        });
                    }
                    //定义弹出居中窗口的方法
                    function popCenterWindow() {
                        init();
                        //计算弹出窗口的左上角X的偏移量
                        var popX = (windowWidth - popWidth) / 2;
                        // 计算弹出窗口的左上角Y的偏移量为窗口的高度 - 弹窗高度 / 2 + 被卷去的页面的top
                        var popY = (windowHeight - popHeight) / 2;
                        //设定窗口的位置
                        $("#center").css("top", popY).css("left", popX).slideToggle(0.01);
                        closeWindow();
                    }
                }
            })
        }

     $(document).on("click", "#savedetail", function () {
            var student={
                stuId:$('#stuId').val(),
                stuNumberId:$('#stuNumberId').val(),
                stuName:$('#stuName').val(),
                stuSex:$('input:radio[name="sex"]:checked').val(),
                stuInstitution:$('#stuInstitution').val(),
                stuClass:$('#stuClass').val()
            };
            var stuId = $('#stuId').val();

            $.ajax({
                type: "post",
                url: "/admin/updateStudent",
                data: student,
                dataType: "json",
                success:function (result) {
                    if (result){
                        alert("修改成功");
                    }else {
                        alert("修改失败")
                    }
                    showAllByPage(1);
                    $('.edit_student').hide("slow");
                    $('#content-box').css('display', 'block');
                }
            });

        })

     $(document).on("click", "#edit-pwd", function () {
         var user={
             userName:$('#admin').text(),
             oldPassword:$('#oldPassword').val(),
             newPassword:$('#newPassword').val()
         };
         $.ajax({
             type: "post",
             url: "/admin/editAdminPwd",
             data: user,
             dataType: "json",
             success:function (result) {
                 if (result){
                     alert("密码修改成功!请重新登录");
                     window.location.href="/index";
                 }else{
                     alert("旧密码输入错误");
                 }
             }
         });

     })

     $(document).on("click", "#addStu", function () {
         var student={
             stuId:$('#addstuId').val(),
             stuNumberId:$('#addstuNumberId').val(),
             stuName:$('#addstuName').val(),
             stuSex:$('input:radio[name="addsex"]:checked').val(),
             stuInstitution:$('#addstuInstitution').val(),
             stuClass:$('#addstuClass').val()
         };
         $.ajax({
             type: "post",
             url: "/admin/addStudent",
             data: student,
             dataType: "json",
             success:function (result) {
                 if (result){
                     alert("录入成功");
                     $('#addstuId').val("");
                     $('#addstuNumberId').val("");
                     $('#addstuName').val("");
                     $("input[name='addsex'][value='女']").attr("checked",false);
                     $("#addstuInstitution").val("请选择");
                     $('#addstuClass').val("");
                 }else {
                     alert("该用户已存在")
                 }
             }
         });

     })

     $(document).on("click", ".list-item", function () {
         $('.edit_student').hide(1);
         $('#content-box').css('display', 'block');
     })
     $(document).on("click", "#exit", function () {
         window.location.href="/index";
     })

 })



			