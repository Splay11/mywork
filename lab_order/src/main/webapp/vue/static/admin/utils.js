function initListFun() {
	$("th").addClass("d-xl-table-cell");
	$("td").addClass("d-xl-table-cell");

	var thTr = $(".text-uppercase");
	var ths = $(thTr[0]).children();
	var isActions = false;
	if (ths.length > 0) {
		if ($(ths[ths.length - 1]).text().indexOf('操作') != -1
				|| $(ths[ths.length - 1]).text().indexOf('Action') != -1) {
			isActions = true;
		}
	}

	var trs = $("tr");
	for (var i = 0; i < trs.length; i++) {
		var tds = $(trs[i]).children();
		if (tds.length > 4) {
			if (isActions == true) {
				for (var j = 3; j < tds.length - 1; j++) {
					$(tds[j]).addClass("d-none");
				}
			} else {
				for (var j = 3; j < tds.length; j++) {
					$(tds[j]).addClass("d-none");
				}
			}

		}
	}

	if (ths.length > 4) {
		var trs = $("tr");
		for (var i = 1; i < trs.length; i++) {
			var tds = $(trs[i]).children();
			if (tds.length > 4) {
				for (var j = 0; j < 3; j++) {
					if ($(tds[j]).find("input").length == 0
							&& $(tds[j]).find("img").length == 0
							&& $(tds[j]).find("a").length == 0
							&& $(tds[j]).find("video").length == 0
							&& $(tds[j]).find("audio").length == 0) {
						$(tds[j]).css("color", "#0665d0");
						$(tds[j]).click(function() {

							clickOnLine(this);
						});
						break;
					}

				}

			}
		}
	}

}

function goLlist() {
	$("#detailContent").css("display", "none");
	$(".listContent").css("display", "block");
}

function clickOnLine(e) {

	var thTr = $(".text-uppercase");
	var ths = $(thTr[0]).children();
	var isActions = false;
	if (ths.length > 0) {
		if ($(ths[ths.length - 1]).text().indexOf('操作') != -1
				|| $(ths[ths.length - 1]).text().indexOf('Action') != -1) {
			isActions = true;
		}
	}

	var tds = $(e).parent().children();
	var lastIndex = tds.length;
	if (isActions == true) {
		lastIndex = tds.length - 1;
	}

	var htmlBody = '';
	var isQrcode = false;
	for (var i = 0; i < lastIndex; i++) {
		if ($(tds[i]).find("input").length == 0) {

			htmlBody += "<tr>";
			htmlBody += "<td style='width:30%'>" + $(ths[i]).text() + "</td>";
			if ($(tds[i]).find(".qrcodeContent").length > 0) {
				var qrcodeContent = $($(tds[i]).find(".qrcodeContent")[0])
						.attr("data-content");
				htmlBody += "<td style='width:70%'><div onclick='maxQrcode(this)' data-content='"
						+ qrcodeContent
						+ "'   class='qrcodeContent'></div></td>";
				isQrcode = true;
			} else {
				if ($(tds[i]).find("img").length > 0) {
					var imgs = $(tds[i]).find("img");
					var htmlVal = '';
					for(var k=0;k<imgs.length;k++){
						var imgVal = $(imgs[k]).attr("src");
						htmlVal+='<img src="'+imgVal+'" style="width:200px;height:200px;margin-left:5px;">';
					}
					htmlBody += "<td style='width:70%'>"+htmlVal+"</td>";
				} else if ($(tds[i]).find("video").length > 0) {
					
					var imgs = $(tds[i]).find("video");
					var htmlVal = '';
					for(var k=0;k<imgs.length;k++){
						var imgVal = $(imgs[k]).attr("src");
						htmlVal+='<video src="'+imgVal+'" style="width:200px;height:200px;margin-left:5px;" controls="controls"></video>';
					}
					htmlBody += "<td style='width:70%'>"+htmlVal+"</td>";
				} else if ($(tds[i]).find("audio").length > 0) {
					
					var imgs = $(tds[i]).find("audio");
					var htmlVal = '';
					for(var k=0;k<imgs.length;k++){
						var imgVal = $(imgs[k]).attr("src");
						htmlVal+='<audio src="'+imgVal+'" style="width:200px;margin-left:5px;" controls="controls"></audio>';
					}
					htmlBody += "<td style='width:70%'>"+htmlVal+"</td>";
					
				} else if ($(tds[i]).find("a").length > 0) {
					
					
					var imgs = $(tds[i]).find("a");
					var htmlVal = '';
					for(var k=0;k<imgs.length;k++){
						var fileVal = $(imgs[k]).attr("file-url");
						var textName = $(imgs[k]).text();
						htmlVal+='<p><a  href="javascript:void(0)" file-url="'+fileVal+'" onclick="downLoadFile(this)">'+textName+'</a></p>';
					}
					htmlBody += "<td style='width:70%'>"+htmlVal+"</td>";
				} else {
					var textVal = $(tds[i]).text();
					htmlBody += '<td style="width:70%">' + textVal + '</td>';
				}
			}
			htmlBody += '</tr>';
		}

	}

	$("#detailBody").html(htmlBody);
	if(isQrcode==true){
		var qrcodeContent = $($("#detailContent")).find(".qrcodeContent");
		for(var i=0;i<qrcodeContent.length;i++){
			var tmpQrcodeVal = $(qrcodeContent[i]).attr("data-content");
			new QRCode(qrcodeContent[i], {
			text: tmpQrcodeVal,
			width: 200,
			height: 200,
			colorDark : '#000000',
			colorLight : '#ffffff',
			correctLevel : QRCode.CorrectLevel.H
			});
			}
	}
	$("#detailContent").css("display", "block");
	$(".listContent").css("display", "none");

}