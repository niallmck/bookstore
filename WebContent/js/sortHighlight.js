/*
 * A Small script to indicate which sort type the customer has selected.
 */

window.onload = function(){
	function getUrlVars() {
	    var vars = {};
	    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
	        vars[key] = value;
	    });
	    return vars;
	};
	
	function highlightSortButton(){
		var sortType = getUrlVars()["sortBy"];
		var reverse = getUrlVars()["reverse"];
		
		console.log(sortType.toLowerCase());
		if (reverse){
			document.getElementById(sortType.toLowerCase() + "reverse").src = "css/img/down_highlighted.png";
		}
		else{
			document.getElementById(sortType.toLowerCase()).src = "css/img/up_highlighted.png";
		}
	};
	
	highlightSortButton();
};