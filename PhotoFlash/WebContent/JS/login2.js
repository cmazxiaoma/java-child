  function checkloginname(){
        	if($('#uuu').val()==""){ 
        		$('#uuu').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#outu').html("<font color='red'><b>×用户名不能为空</b></font>");
    			return false;
        	}
        	
        	
        }
        
        function checkloginpwd(){
        	if($('#p').val()==""){ 
        		$('#p').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#pwd').html("<font color='red'><b>×密码不能为空</b></font>");
    			return false;
        	}
     
        }
        
        function check(){
        	if($('#uuu').val()==""){ 
        		$('#uuu').css({
    				border: "1px solid red",
    				boxShadow: "0 0 2px red"
    			});
    			$('#outu').html("<font color='red'><b>×用户名不能为空</b></font>");
    			if($('#p').val()==""){ 
            		$('#p').css({
            			border: "1px solid red",
            			boxShadow: "0 0 2px red"
            		});
            		$('#pwd').html("<font color='red'><b>×密码不能为空</b></font>");
            		return false;
            	}
        	}
        	return true;
        }
        
        
        function clearloginname(){
    	    $('#outu').html("");
    	    $('#login_error').html("");
    	    
    			return false;
        }
        
        
        function clearloginpwd(){
        	$('#pwd').html("");
        	 $('#login_error').html("");
        	return false;
        }
        
        