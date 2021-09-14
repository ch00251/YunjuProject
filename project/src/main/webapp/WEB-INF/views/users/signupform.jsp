<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signupform.jsp</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
	<h1>회원 가입</h1>
	<form action="signup.do" method="post" id="signupform">
		<div class="form-group has-feedback">
			<label for="userId" class="control-label">아이디</label>
			<input type="text" class="form-control" id="userId" name="userId" required="required"/>
			<p class="help-block" id="id_check"></p>
			<!--
			<span class="glyphicon glyphicon-remove form-control-feedback"></span>
			<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			-->
		</div>
		<div class="form-group has-feedback">
			<label for="userPwd" class="control-label">비밀번호</label>
			<input type="password" class="form-control" id="userPwd" name="userPwd"/>
		</div>
		<div class="form-group has-feedback">
			<label for="userPwd2" class="control-label">비밀번호 확인</label>
			<input type="password" class="form-control" id="userPwd2" name="userPwd2" />
			<p id="pwd_check"></p>
		</div>
		<div class="form-group has-feedback">
			<label for="userName" class="control-label">이름</label>
			<input type="text" class="form-control" id="userName" name="userName" />			
		</div>
		<div class="form-group has-feedback">
			<label for="userPhone" class="control-label">전화번호</label>
			<input type="text" class="form-control" id="userPhone" name="userPhone" onkeyup="inputPhoneNumber(this);" placeholder="전화번호를 입력해주세요" required="required" maxlength="13"/>
			<script>
				function inputPhoneNumber(obj){
					var number=obj.value.replace(/[^0-9]/g,"");
					var phone="";
					
					if(number.length<4){
						return number;
					}else if(number.length<7){
						phone+=number.substr(0,3);
						phone+="-";
						phone+=number.substr(3);
					}else if(number.length<11){
						phone+=number.substr(0,3);
						phone+="-";
						phone+=number.substr(3,3);
						phone+="-";
						phone+=number.substr(6);
					}else{
						phone += number.substr(0, 3);
                        phone += "-";
                        phone += number.substr(3, 4);
                        phone += "-";
                        phone += number.substr(7);
					}
					obj.value=phone;
				}
			</script>
		</div>
		<div class="form-group has-feedback">
			<label for="email" class="control-label">이메일</label>
			<input type="email" class="form-control" id="email" name="email" placeholder="E-mail을 입력하세요"/>
			<p class="help-block" id="email_notmatch">이메일 형식에 맞게 입력하세요</p>
			<!--
			<span class="glyphicon glyphicon-remove form-control-feedback"></span>
			<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			-->
		</div>
		<div class="form-group has-feedback">
			<label for="userAddr" class="control-label">주소</label>
			<ng-class="{'has-success':myForm.userAddr1.$valid,'has-error':myForm.userAddr1.$invalid &&myForm.userAddr1.$dirty}"></ng-class>
			<input class="form-control" type="text" name="userAddr1" id="userAddrA" placeholder="우편번호" ng-model="userAddr1" ng-required="true"/>
            
            <input id="addrbtn" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" ><label for="userAddr1"><strong id="required"></strong></label><br>
            
    		
            <input class="form-control" type="text" name="userAddr2" id="userAddr2" placeholder="기본주소" ng-model="userAddr2" ng-required="true"/>
            <label for="userAddr2">기본 주소 <strong id="required"></strong></label>
            <span id="guide" style="color:#999;display:none"></span>
            <span ng-show="myForm.userAddr2.$valid" class="glyphicon glyphicon-ok form-control-feedback"></span>
            <span ng-show="myForm.userAddr2.$invalid && myForm.userAddr2.$dirty" class="glyphicon glyphicon-remove form-control-feedback"></span>
    		<br />
            <input class="form-control" type="text" name="userAddr3" id="userAddr3" placeholder="상세주소"/>
            <label for="userAddr3">상세 주소</label>
			<script>
		    $("#userAddrA").on("click",function(){
		        sample4_execDaumPostcode();
		        
		     });
		     $("#userAddr2").on("click",function(){
		        sample4_execDaumPostcode();
		     
		     });
    		</script>
		</div>
		<div class="form-group has-feedback">
			<label for="birthday" class="control-label">생년월일</label>
			<input class="form-control" type="date" id="birthday" name="birthday" required="required"/>
		</div>
		<div class="sbtn">
			<button type="reset" class="signbtn" onclick="location.href='../index.do'">취소</button>
			<button type="submit" id="login_button" class="signbtn" name="signupbtn">회원가입</button>
		</div>
	</form>
</div>

<script type="text/javascript">
	//아이디 사용할 수 있는지 여부
	var isIdUsable=false;
	//아이디를 입력 했는지 여부
	var isIdInput=false;
	//아이디 입력란에 한번이라도 입력한 적이 있는지 여부
	var isIdDirty=false;
	
	$("#userId").on("input",function(){
		isIdDirty=true;
		//입력한 아이디 읽어오기
		var inputId=$("#userId").val();
		//서버에 보내서 사용가능 여부 응답받기
		$.ajax({
			url:"${pageContext.request.contextPath}/users/checkId.do",
			method="post",
			data:{inputId:inputId},
			success:function(responseData){
				if(responseData.isExist){//이미 존재하는 아이디라면
					$("#id_check").text("사용중인 아이디입니다.");
					$("#id_check").css("color", "red");
					$("#reg_submit").attr("disabled", true);
				}else{
					$("#id_check").text("");
				}
			}
		});
	});
	

	var isPwdCheck=false;
	$("#userPwd2, #userPwd").on("input",function(){
		var isPwd1=$("#userPwd").val();
		var isPwd2=$("#userPwd2").val();
		if(isPwd1 != isPwd2){
			isPwdCheck=true;
		}else{
			isPwdCkeck=false;
		}
		if(isPwdCheck){
			$("#pwd_check").text("비밀번호가 다릅니다.");
			$("#pwd_check").css("color","red");
			$("#reg_submit").attr("disabled", true);
		}else if(!isPwdCheck){
			$("#pass_check").text("");
		}else{
			$("#pass_check").text("");
		}
	})
</script>

<!-- 다음 주소 API 사용 -->    
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
         
new daum.Postcode({
   oncomplete: function(data) {
   // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
   
   // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
   // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
   var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
   var extraRoadAddr = ''; // 도로명 조합형 주소 변수
   
   // 법정동명이 있을 경우 추가한다. (법정리는 제외)
   // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                      extraRoadAddr += data.bname; }
   // 건물명이 있고, 공동주택일 경우 추가한다.
   if(data.buildingName !== '' && data.apartment === 'Y'){
                     extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName); }
   // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
   if(extraRoadAddr !== ''){
                      extraRoadAddr = ' (' + extraRoadAddr + ')'; }
   // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
   if(fullRoadAddr !== ''){
                      fullRoadAddr += extraRoadAddr; }
   
   // 우편번호와 주소 정보를 해당 필드에 넣는다.
   document.getElementById('userAddrA').value = data.zonecode; //5자리 새우편번호 사용
   document.getElementById('userAddr2').value = fullRoadAddr;
   //document.getElementById('userAddr3').value = data.jibunAddress;
              
   // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
   if(data.autoRoadAddress) {
      //예상되는 도로명 주소에 조합형 주소를 추가한다.
      var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
      document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
   
      } else if(data.autoJibunAddress) {
        var expJibunAddr = data.autoJibunAddress;
        document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
        } else {
        document.getElementById('guide').innerHTML = '';
        }
           }
          }).open();
      }
</script>
</body>
</html>