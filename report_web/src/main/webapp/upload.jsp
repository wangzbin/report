<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Excel文件处理</title>
    <%--<script type="text/javascript" src="<c:url value='jquery-1.9.1.min.js'/>"></script>--%>
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script>
        $(function(){
            var $wrap = $(".wrap");
            var find = function(str){
                return $wrap.find(str);
            }
            var getJname = function(name){
                return find("input[name='"+name+"']");
            }
            getJname("Upload").click(function(){
                var form = new FormData(document.getElementById("tf"));
                $.ajax({
                    url:"<c:url value='/File/UploadExcel'/>",
                    type:"post",
                    data:form,
                    dataType:"json",
                    processData:false,
                    contentType:false,
                    success:function(data){
                        //window.clearInterval(timer);
                        if(data.msg == "success"){
                            alert("提交文件成功,已将数据存入数据库");
                        }
                    },
                    error:function(e){
                        alert("错误！");
                        //window.clearInterval(timer);
                    }
                });
            })
            getJname("Download").click(function(){
                $.post("<c:url value='/File/DownLoadExcel'/>",{"id":"3"},function(data){
                    //alert("下载文件成功");
                },"json")
            })
        })
    </script>
</head>
<body>
    <div class="wrap">
        <form action="/report/manage/uploadExcel" method="post" enctype="multipart/form-data">
            <input type="file" name="excelName" />
            <button>提交</button>
        </form>
    </div>
</body>
</html>