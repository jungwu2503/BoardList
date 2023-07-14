<%@page import="bitedu.bipa.boardList.utils.DateCalculation"%>
<%@page import="bitedu.bipa.boardList.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세</title>
 <style>
    table, td, th {
        border : 1px solid black;
        border-collapse: collapse;
        margin: 20px auto;
    }
    td {
        width: 150px;
        height: 50px;
        padding: 5px;
        font-size: 20px;
        /* text-align: center; */
    }

    input , select {
        font-size: 20px;
    }
    .data_ui {
        width: 350px; 
        height: 50px;
    }

    button {
        font-size: 15px;
        margin: 5px;
    }
    
    
    #sending {
        text-align: center;
    }
    
    input.poster :disabled {
        background: gray;
    }
    
    #form {
        font-size: 30px;
    }
    
    #message {
        color: red;
    }
    #content{
        margin-left:150px;
    }
    button{
        font-size:30px;
        margin-left:270px
        
    }
</style>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		$('#go_board_list').on('click',function(){ 
			$('#frm').attr('action','list.do');
			$('#frm').attr('method','get');
			$('#frm').submit();
		});
		
		$('#go_board_regist').on('click',function(){
			$('#frm').attr('action','regist.do');
			$('#cdt').val($('#cdt').val()+" 00:00:00");
			$('#frm').submit();
	});
}

</script>
<body>
<form action="" method="post" id="frm">
<table>
    <tr><th colspan="5" id="title"><h3>제목</h3></th></tr>
    <td>작성자</td>
    <td><input type="text" id="writer" name="writer"></td>
    <td>작성일</td>
    <td><input type="text" id="cdt" name="cdt"></td>
    <textarea name="content" id="content" cols="89" rows="30"></textarea>
    <tr>
    	<td colspan="5" id="sending">
    		<input type="submit" value="등록" id="go_board_regist"> 
     		<input type="submit" value="취소" id="go_board_list">
        </td>
   	</tr>
</table>
</form>

</body>
</html>