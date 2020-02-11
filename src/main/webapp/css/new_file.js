onscroll = function() {
	var st = document.documentElement.scrollTop || document.body.scrollTop;
	if(!js.offsetWidth && st >= 600) {
		js.style.display = 'block';
	} else if(!!js.offsetWidth && st < 600) {
		js.style.display = 'none';
	}
}

function xianshi() {
	document.getElementById('dl').style.display = 'block';
}

function yincang() {
	document.getElementById('dl').style.display = 'none';
}

function xianshi1() {
	document.getElementById('d3').style.display = 'block';
}

function xianshi2() {
	document.getElementById('d3').style.display = 'none';
}

function vip() {
	var name = document.getElementById('xrz').value;
	document.getElementById('ID').innerHTML='欢迎您：'+name;
}