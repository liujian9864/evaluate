
 $(function() {
        showAllStudentByPage(1);
        function showAllStudentByPage(currentPage) {

            var teaNumberId=$("#teanumberId").val();
            var teaName=$("#teaname").val();
            var teaInstitution=$("#teainstitution").val();
            var teaProfessional=$("#teaprofessional").val();
            // $.ajax({
            //     type: "post",
            //     url: "/loginUser",
            //     dataType: "json",
            //     success:function (result){
            //         var user=result.userName+"("+result.userType+")"
            //         $('#loginuser').html(user);
            //         $('#admin').html(result.userName);
            //
            //     }
            // })
            $.ajax({
                type: "post",
                url: "/admin/allteacher",
                data: {currentPage:currentPage,teaNumberId:teaNumberId,teaName:teaName,teaInstitution:teaInstitution,teaProfessional:teaProfessional},
                dataType: "json",
                success: function (result) {
                    var totalPage = result.totalPage;
                    var currentPage = result.currentPage;

                    var tbody = "";
                    for (i = 0; i <  result.teachers.length; i++) {
                        var tr = "";
                        tr += "<tr>";
                        tr += "<td>" + result.teachers[i].teaNumberId + "</td>";
                        tr += "<td>" + result.teachers[i].teaName + "</td>";
                        tr += "<td>" + result.teachers[i].teaSex + "</td>";
                        tr += "<td>" + result.teachers[i].teaInstitution + "</td>";
                        tr += "<td>" + result.teachers[i].teaProfessional + "</td>";
                        tr += "<td><button value='" + result.teachers[i].teaId + "' type='button' class='btn btn-primary modButton modteacher'>修改</button> <button value='" + result.teachers[i].teaId + "' type='button' class='btn btn-danger delButton delteacher' title='删除用户'>删除</button></td>"
                        tr += "</tr>";
                        tbody += tr;
                    }
                    $("#teacherbody").html(tbody);

                    var ul = "";
                    for(i=1;i<=totalPage;i++){
                        var li = "";
                        li += "<li class='fenli fenli2'><a class='fenye fenye2' id='numberPage2'>"+i+"</a></li>";
                        ul += li;
                    }
                    var uli =""
                    uli += "<li><a class='fenye fenye2' id='previousPage2'>«</a></li>";
                    uli += ul;
                    uli += "<li><a class='fenye fenye2' id='nextPage2'>»</a></li>";
                        $("#showAllTeacherFenye").html(uli);

                    $(".fenye2").unbind("click");
                    $(".fenye2").click(function(){
                        var id = $(this).attr("id");
                        if(id == "previousPage2"){
                            if(currentPage == 1){
                                alert("已经第一页了");
                            }else{
                                showAllStudentByPage(currentPage-1);
                            }
                        }else if(id == "nextPage2"){
                            if(currentPage == totalPage){
                                alert("已经是最后一页了");
                            }else{
                                showAllStudentByPage(currentPage+1);
                            }
                        }else if(id == "numberPage2"){
                            showAllStudentByPage($(this).text());
                        }
                    })
                    var number = currentPage-1;
                    $(".fenli2:eq("+number+")").attr("class","am-active");

                    $("#searchTeacher").unbind("click");
                    $("#searchTeacher").click(function(){
                        showAllStudentByPage(1);
                    })

                    $(".delteacher").unbind("click");
                    $(".delteacher").click(function(){
                        var msg = "您真的确定要删除吗？\n\n请确认！";
                        if (confirm(msg)==true){
                        var teaId = $(this).val();
                        $.ajax({
                            type: "post",
                            url: "/admin/deleteTeacherById",
                            data: {teaId:teaId},
                            dataType: "json",
                            success:showAllStudentByPage(1)
                        })
                            alert("删除成功")
                        }else{

                        }
                    })

                    $(".modteacher").unbind("click");
                    $(".modteacher").click(function(){
                        $('#content-box').css('display', 'none');
                        popCenterWindow1();
                        var teaId = $(this).val();
                        $.ajax({
                            type: "post",
                            url: "/admin/selectTeacherById",
                            data: {teaId:teaId},
                            dataType: "json",
                            success:function (result) {
                                $('#tea-Id').val(result.teaId);
                                $('#tea-NumberId').val(result.teaNumberId);
                                $('#tea-Name').val(result.teaName);
                                if (result.teaSex=='男'){
                                    $("input[name='tea-sex'][value='男']").attr("checked",true);
                                }else {
                                    $("input[name='tea-sex'][value='女']").attr("checked",true);
                                }
                                $("#tea-Institution ").val(result.teaInstitution);
                                $("#tea-Professional ").val(result.teaProfessional);
                            }
                        });
                    })

                    //获取窗口的高度
                    var windowHeight1;
                    //获取窗口的宽度
                    var windowWidth1;
                    //获取弹窗的宽度
                    var popWidth1;
                    //获取弹窗高度
                    var popHeight1;

                    function init1() {
                        windowHeight1 = $(window).height();
                        windowWidth1 = $(window).width();
                        popHeight1 = $(".edit_student").height();
                        popWidth1 = $(".edit_student").width();
                    }
                    //关闭窗口的方法
                    function closeWindow1() {
                        $("#close1").click(function () {
                            $('.edit_student1').hide(1);
                            $('#content-box').css('display', 'block');
                        });
                    }
                    //定义弹出居中窗口的方法
                    function popCenterWindow1() {
                        init1();
                        //计算弹出窗口的左上角X的偏移量
                        var popX = (windowWidth1 - popWidth1) / 2;
                        // 计算弹出窗口的左上角Y的偏移量为窗口的高度 - 弹窗高度 / 2 + 被卷去的页面的top
                        var popY = (windowHeight1 - popHeight1) / 2;
                        //设定窗口的位置
                        $("#center1").css("top", popY).css("left", popX).slideToggle(0.01);
                        closeWindow1();
                    }
                }
            })
        }

     $(document).on("click", "#savedetail1", function () {
            var teacher={
                teaId:$('#tea-Id').val(),
                teaNumberId:$('#tea-NumberId').val(),
                teaName:$('#tea-Name').val(),
                teaSex:$('input:radio[name="tea-sex"]:checked').val(),
                teaInstitution:$('#tea-Institution').val(),
                teaProfessional:$('#tea-Professional').val()
            };
            $.ajax({
                type: "post",
                url: "/admin/updateTeacher",
                data: teacher,
                dataType: "json",
                success:function (result) {
                    if (result){
                        alert("修改成功");
                    }else {
                        alert("修改失败")
                    }
                    showAllStudentByPage(1);
                    $('.edit_student1').hide("slow");
                    $('#content-box').css('display', 'block');
                }
            });

        })

     $(document).on("click", "#addTea", function () {
         var teacher={
             teaId:$('#addteaId').val(),
             teaNumberId:$('#addteaNumberId').val(),
             teaName:$('#addteaName').val(),
             teaSex:$('input:radio[name="addteasex"]:checked').val(),
             teaInstitution:$('#addteaInstitution').val(),
             teaProfessional:$('#addteaProfessional').val()
         };
         $.ajax({
             type: "post",
             url: "/admin/addTeacher",
             data: teacher,
             dataType: "json",
             success:function (result) {
                 if (result){
                     alert("录入成功");
                     $('#addteaId').val("");
                     $('#addteaNumberId').val("");
                     $('#addteaName').val("");
                     $("input[name='addteasex'][value='女']").attr("checked",false);
                     $("#addteaInstitution").val("信息工程学院");
                     $("#addteaProfessional").val("讲师");

                 }else {
                     alert("该用户已存在")
                 }
             }
         });

     })

 })



			