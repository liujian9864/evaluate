
 $(function() {
        showAllEvaByPage(1);
        function showAllEvaByPage(currentPage) {

            var courseNumberId=$("#evaCourseNumberId").val();
            var courseName=$("#evaCourseName").val();
            var courseClass=$("#evaCourseClass").val();
            var courseTeacher=$("#evaCourseTeacher").val();
            $.ajax({
                type: "post",
                url: "/admin/allEva",
                data: {currentPage:currentPage,courseNumberId:courseNumberId,courseName:courseName,courseClass:courseClass,courseTeacher:courseTeacher},
                dataType: "json",
                success: function (result) {
                    var totalPage = result.totalPage;
                    var currentPage = result.currentPage;

                    var tbody = "";
                    for (i = 0; i <  result.evas.length; i++) {
                        var tr = "";
                        tr += "<tr>";
                        tr += "<td>" + result.evas[i].courseTeacher + "</td>";
                        tr += "<td>" + result.evas[i].courseNumberId + "</td>";
                        tr += "<td>" + result.evas[i].courseName + "</td>";
                        tr += "<td>" + result.evas[i].courseClass + "</td>";
                        tr += "<td>" + result.evas[i].evaGradeAvgCount + "</td>";
                        if(result.evas[i].evaGradeAvgCount<4){
                            tr += "<td>不合格</td>";
                        }else if (result.evas[i].evaGradeAvgCount<8){
                            tr += "<td>一般</td>";
                        }else{
                            tr += "<td>优秀</td>";
                        }
                        // tr += "<td><button value='" + result.evas[i].courseId + "' type='button' class='btn btn-primary modButton modCourse'>修改</button> <button value='" + result.evas[i].courseId + "' type='button' class='btn btn-danger delButton delCourse' title='删除用户'>删除</button></td>"
                        tr += "</tr>";
                        tbody += tr;
                    }
                    $("#evabody").html(tbody);

                    var ul = "";
                    for(i=1;i<=totalPage;i++){
                        var li = "";
                        li += "<li class='fenli fenli4'><a class='fenye fenye4' id='numberPage4'>"+i+"</a></li>";
                        ul += li;
                    }
                    var uli =""
                    uli += "<li><a class='fenye fenye4' id='previousPage4'>«</a></li>";
                    uli += ul;
                    uli += "<li><a class='fenye fenye4' id='nextPage4'>»</a></li>";
                        $("#showAllEvaFenye").html(uli);

                    $(".fenye4").unbind("click");
                    $(".fenye4").click(function(){
                        var id = $(this).attr("id");
                        if(id == "previousPage4"){
                            if(currentPage == 1){
                                alert("已经第一页了");
                            }else{
                                showAllEvaByPage(currentPage-1);
                            }
                        }else if(id == "nextPage4"){
                            if(currentPage == totalPage){
                                alert("已经是最后一页了");
                            }else{
                                showAllEvaByPage(currentPage+1);
                            }
                        }else if(id == "numberPage4"){
                            showAllEvaByPage($(this).text());
                        }
                    })
                    var number = currentPage-1;
                    $(".fenli4:eq("+number+")").attr("class","am-active");

                    $("#searchEva").unbind("click");
                    $("#searchEva").click(function(){
                        showAllEvaByPage(1);
                    })
                }
            })
        }

 })



			