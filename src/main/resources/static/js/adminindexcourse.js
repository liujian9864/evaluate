
 $(function() {
        showAllCourseByPage(1);
        function showAllCourseByPage(currentPage) {

            var courseNumberId=$("#courseNumberId").val();
            var courseName=$("#courseName").val();
            var courseClass=$("#courseClass").val();
            var courseTeacher=$("#courseTeacher").val();
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
                url: "/admin/allCourse",
                data: {currentPage:currentPage,courseNumberId:courseNumberId,courseName:courseName,courseClass:courseClass,courseTeacher:courseTeacher},
                dataType: "json",
                success: function (result) {
                    var totalPage = result.totalPage;
                    var currentPage = result.currentPage;

                    var tbody = "";
                    for (i = 0; i <  result.courses.length; i++) {
                        var tr = "";
                        tr += "<tr>";
                        tr += "<td>" + result.courses[i].courseNumberId + "</td>";
                        tr += "<td>" + result.courses[i].courseName + "</td>";
                        tr += "<td>" + result.courses[i].courseClass + "</td>";
                        tr += "<td>" + result.courses[i].courseTeacher + "</td>";
                        tr += "<td>" + result.courses[i].courseEvaluate + "</td>";
                        tr += "<td><button value='" + result.courses[i].courseId + "' type='button' class='btn btn-primary modButton modCourse'>修改</button> <button value='" + result.courses[i].courseId + "' type='button' class='btn btn-danger delButton delCourse' title='删除用户'>删除</button></td>"
                        tr += "</tr>";
                        tbody += tr;
                    }
                    $("#coursebody").html(tbody);

                    var ul = "";
                    for(i=1;i<=totalPage;i++){
                        var li = "";
                        li += "<li class='fenli fenli3'><a class='fenye fenye3' id='numberPage3'>"+i+"</a></li>";
                        ul += li;
                    }
                    var uli =""
                    uli += "<li><a class='fenye fenye3' id='previousPage3'>«</a></li>";
                    uli += ul;
                    uli += "<li><a class='fenye fenye3' id='nextPage3'>»</a></li>";
                        $("#showAllCourseFenye").html(uli);

                    $(".fenye3").unbind("click");
                    $(".fenye3").click(function(){
                        var id = $(this).attr("id");
                        if(id == "previousPage3"){
                            if(currentPage == 1){
                                alert("已经第一页了");
                            }else{
                                showAllCourseByPage(currentPage-1);
                            }
                        }else if(id == "nextPage3"){
                            if(currentPage == totalPage){
                                alert("已经是最后一页了");
                            }else{
                                showAllCourseByPage(currentPage+1);
                            }
                        }else if(id == "numberPage3"){
                            showAllCourseByPage($(this).text());
                        }
                    })
                    var number = currentPage-1;
                    $(".fenli3:eq("+number+")").attr("class","am-active");

                    $("#searchCourse").unbind("click");
                    $("#searchCourse").click(function(){
                        showAllCourseByPage(1);
                    })

                    $(".delCourse").unbind("click");
                    $(".delCourse").click(function(){
                        var msg = "您真的确定要删除吗？\n\n请确认！";
                        if (confirm(msg)==true){
                        var courseId = $(this).val();
                        $.ajax({
                            type: "post",
                            url: "/admin/deleteCourseById",
                            data: {courseId:courseId},
                            dataType: "json",
                            success:showAllCourseByPage(1)
                        })
                            alert("删除成功")
                        }else{

                        }
                    })

                    $(".modCourse").unbind("click");
                    $(".modCourse").click(function(){
                        $('#content-box').css('display', 'none');
                        popCenterWindow2();
                        var courseId = $(this).val();
                        $.ajax({
                            type: "post",
                            url: "/admin/selectCourseById",
                            data: {courseId:courseId},
                            dataType: "json",
                            success:function (result) {
                                $('#add-CourseId').val(result.courseId);
                                $('#add-CourseNumberId').val(result.courseNumberId);
                                $('#add-CourseName').val(result.courseName);
                                $('#add-CourseClass').val(result.courseClass);
                                $('#add-CourseTeacher').val(result.courseTeacher);
                                if (result.courseEvaluate=='是'){
                                    $("input[name='add-CourseEvaluate'][value='是']").attr("checked",true);
                                }else {
                                    $("input[name='add-CourseEvaluate'][value='否']").attr("checked",true);
                                }
                            }
                        });
                    })

                    //获取窗口的高度
                    var windowHeight2;
                    //获取窗口的宽度
                    var windowWidth2;
                    //获取弹窗的宽度
                    var popWidth2;
                    //获取弹窗高度
                    var popHeight2;

                    function init2() {
                        windowHeight2 = $(window).height();
                        windowWidth2 = $(window).width();
                        popHeight2 = $(".edit_student").height();
                        popWidth2 = $(".edit_student").width();
                    }
                    //关闭窗口的方法
                    function closeWindow2() {
                        $("#close2").click(function () {
                            $('.edit_student2').hide(1);
                            $('#content-box').css('display', 'block');
                        });
                    }
                    //定义弹出居中窗口的方法
                    function popCenterWindow2() {
                        init2();
                        //计算弹出窗口的左上角X的偏移量
                        var popX = (windowWidth2 - popWidth2) / 2;
                        // 计算弹出窗口的左上角Y的偏移量为窗口的高度 - 弹窗高度 / 2 + 被卷去的页面的top
                        var popY = (windowHeight2 - popHeight2) / 2;
                        //设定窗口的位置
                        $("#center2").css("top", popY).css("left", popX).slideToggle(0.01);
                        closeWindow2();
                    }
                }
            })
        }

     $(document).on("click", "#savedetail2", function () {
            var course={
                courseId:$('#add-CourseId').val(),
                courseNumberId:$('#add-CourseNumberId').val(),
                courseName:$('#add-CourseName').val(),
                courseClass:$('#add-CourseClass').val(),
                courseTeacher:$('#add-CourseTeacher').val(),
                courseEvaluate:$('input:radio[name="add-CourseEvaluate"]:checked').val()
            };
            $.ajax({
                type: "post",
                url: "/admin/updateCourse",
                data: course,
                dataType: "json",
                success:function (result) {
                    if (result){
                        alert("修改成功");
                    }else {
                        alert("修改失败")
                    }
                    showAllCourseByPage(1);
                    $('.edit_student2').hide("slow");
                    $('#content-box').css('display', 'block');
                }
            });

        })

     $(document).on("click", "#addCourse", function () {
         var course={
             courseId:$('#addCourseId').val(),
             courseNumberId:$('#addCourseNumberId').val(),
             courseName:$('#addCourseName').val(),
             courseClass:$('#addCourseClass').val(),
             courseTeacher:$('#addCourseTeacher').val(),
             courseEvaluate:$('input:radio[name="addCourseEvaluate"]:checked').val()
         };
         $.ajax({
             type: "post",
             url: "/admin/addCourse",
             data: course,
             dataType: "json",
             success:function (result) {
                 if (result){
                     alert("录入成功");
                     showAllCourseByPage(1);
                     $('#addCourseId').val("");
                     $('#addCourseNumberId').val("");
                     $('#addCourseName').val("");
                     $('#addCourseClass').val("");
                     $("#addCourseTeacher").val("");
                     $("input[name='addCourseEvaluate'][value='是']").attr("checked",true);
                 }else {
                     alert("录入失败")
                 }
             }
         });

     })

 })



			