//验证函数列表
/*
.trim//去空格
.ltrim//去左空格
.rtrim//去右空格
.len//字符长度
isNumber(str)//验证字符串是否仅数字
isPhone(str)//检查移动手机号码
isEmail(str)//检查email
isTime(str)//时间格式正则表达式，格式为"yyyy-MM-dd hh:mm:ss"
isDate(str)//日期格式正则表达式，格式为"yyyy-MM-dd"
isNumOrLetter(str)// 验证字符串是否仅包含字母和数字
isPercent(str)//验证百分比数字格式是否正确。不能大于等于100%，小数点后最长5位数字。
isIp(str)//验证ip
*/
//其它函数列表
/*
setBoxChecked(mFormObj ,boxName ,checked)//全部被选中或全部不被选中
dispInfo(obj)//显示或隐藏部分信息
getLength(str)//检测一个字符串的真实长度(字符长度)
 getoffset(e) //取得控件得绝对位置
 compare_date(sdate,edate)//时间比较函数
 limit_date(sdate,edate,day_num)//不能超过多少天
 checkTelStartEnd(start,end)//结束号段必须大于起始号段，号段个数比一定相同
*/

//trim函数
//String.prototype.trim = function()
//{
//	return this.replace(/(^\s*)|(\s*$)/g, "");
//}
String.prototype.ltrim=function(){
	return this.replace(/^\s*/g,'');
};
String.prototype.rtrim=function(){
	return this.replace(/\s*$/g,'');
};
// 字符长度
String.prototype.len=function()
{
    return this.replace(/[^\x00-\xff]/g,"aa").length;
}

// 验证字符串是否仅数字
function isNumber(str)
{
    var reg = /^[0-9]*$/;
    return reg.test(str);
}

// 检查移动手机号码
function isPhone(str)
{
   // var re=/^(((86)?(13[4-9]{1})|(15[0189]{1}))+\d{8})$/;
    var re =/^(86)?(1[3|5|8][0-9]\d{8})$/;
    return re.test(str);
}
// 检查email
function isEmail(str)
{
    // var re=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
    var re=/^\s*([A-Za-z0-9_\-]+(\.\w+)*@(\w+\.)+\w{2,3})\s*$/;
    return re.test(str);
}
// 检查时间
// 时间格式正则表达式，格式为"yyyy-MM-dd hh:mm:ss"
function isTime(str)
{
    var re = /^\d{4}-[0-1][0-9]-[0-3][0-9]\s(((0|1)\d)|(2(0|1|2|3))):[0-5][0-9]:[0-5][0-9]$/;
    return re.test(str)
}
// 检查日期
// 日期格式正则表达式，格式为"yyyy-MM-dd"
function isDate(str)
{
    var re = /^\d{4}-[0-1][0-9]-[0-3][0-9]$/;
    return re.test(str)
}

// 验证字符串是否仅包含字母和数字
function isNumOrLetter(str)
{
    var reg = /^[A-Za-z0-9]*$/;
    return reg.test(str);
}
// 验证字符串是否仅包含字母和数字
function isLetter(str)
{
    var reg = /^[A-Za-z]*$/;
    return reg.test(str);
}
/**
 * @func checkIdCard
 * @desc 身份证验证函数
 * @author Lone Chain
 * @version 1.0.0
 * @date 2011-9-19
 * 
 * @parame {String} idcard 要验证的身份证号码字符串
 * @return {Object||Boolen} 验证成功返回一个包含省份、生日、性别的对象， 失败返回false
 */
function checkIdCard(idcard){
	var cities = {
		11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
		21:"辽宁",22:"吉林",23:"黑龙江",
		31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",
		41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",
		50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",
		61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",
		71:"台湾",
		81:"香港",82:"澳门",
		91:"国外"
	};
	idcard = idcard.toString();
	if(!(idcard.length==15||idcard.length==18)){
		return false;
	}
	// 验证位数是否正确
	var info = idcard.length==15 ?idcard.match(/^([1-9]\d)\d{4}(\d{2})(\d{2})(\d{2})\d{2}(\d)$/i) :idcard.match(/^([1-9]\d)\d{4}(\d{4})(\d{2})(\d{2})\d{2}(\d)[\dx]$/i);
	if(info==null||info==undefined){
		return false;
	}
	if (!info.length){
		return false;
	}
	// 验证省份是否正确
	if (!cities[info[1]]){
		return false;
	}
	// 验证生日是否正确
	var birthday = new Date(info[2], info[3]-1, info[4]);
	if (! (
		(birthday.getFullYear()==info[2]||birthday.getYear()==info[2]) &&
		birthday.getMonth()+1 == parseInt(info[3],10) &&
		birthday.getDate() == parseInt(info[4], 10)
	)){
		return false;
	}
	// 18位身份证校验
	if (info[0].length==18){
		var sum = 0;
		info[0] = info[0].replace(/x/i, "a");
		for(var i=17; i>=0;){
			sum += (Math.pow(2,i) % 11) * parseInt(info[0].charAt(17-i), 11);
			i-=1;
		}
		if((sum % 11) != 1){
			return false;
		}
	}
	return {
		city: cities[info[1]],
		birthday: birthday,
		sex: info[5] % 2 ? "男" : "女"
	};
}
function isTelephone(areaCode,mainCode,extCode){
	if((areaCode==""||areaCode==undefined)||
			(mainCode==""||mainCode==undefined)||
			(extCode==""||extCode==undefined))
		return false;
	if(areaCode==""){
		return false;
	}else if(!isNumber(areaCode)||areaCode.length>4){
		return false;
	}
	if(mainCode==""){
		return false;
	}else if(!isNumber(mainCode)||mainCode.length>11){
		return false;
	}
// if(extCode==""){
// return false;
// }else
// }
	if(!isNumber(extCode))
		 return false;
	return true;
}
// 验证百分比数字格式是否正确。不能大于等于100%，小数点后最长5位数字。
function isPercent(str)
{
    var reg = /^[0-9]\d?([.]\d{1,5})?[%]$/;
    return reg.test(str);
}

// 验证ip
function isIp(str)
{
	var reg=/^[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}$/
	test_ip=str.split(".")
	if(!reg.test(str))
	{
		 return false; 
	 }
	if(test_ip.length!=4)
	{
		 return false;
	}
	if(isNaN(test_ip[0])||isNaN(test_ip[1])||isNaN(test_ip[2])||isNaN(test_ip[3]))
	{
		 return false;
	 }
	if(test_ip[0]<0||test_ip[1]<0||test_ip[2]<0||test_ip[3]<0)
	{
		 return false;
	}
	if(test_ip[0]>255||test_ip[1]>255||test_ip[2]>255||test_ip[3]>255)
	{
		 return false;
	}
	 return true;
}
/**
 * 设置mFormObj表单对象所有名为boxName的chekcbox元素全部被选中或全部不被选中
 * 
 * @param mFormObj
 *            表单对象
 * @param boxName
 *            checkbox元素的名字,字符串类型
 * @param checked
 *            true(选中)/false(不选中)
 */
function setBoxChecked(mFormObj ,boxName ,checked)
{
    if(mFormObj == null) return ;
    var count = mFormObj.elements.length ;
    for(var i=0 ;i<count ;)
    {
        var e = mFormObj.elements[i] ;
        if (e.type=="checkbox" && e.name == boxName)
        {
            e.checked = checked ;
        }
        i += 1;
    }
}

/**
 * 显示或隐藏部分信息
 * 
 * @param obj
 *            在
 *            <td> 中设置的对象
 */
function dispInfo(obj)
{
  if(obj.style.display=='none')
    obj.style.display='';
  else
    obj.style.display='none';
}
/**
 * 检测一个字符串的真实长度（一个汉字算2个字节）
 */
function getLength(str)
{
    var length2 = str.length;
    for(var i = 0; i < str.length;)
    {
		if(str.charAt(i)>'~' || str.charAt(i)<' ')
		{
		    length2 += 1;
		}
		i += 1;
    }
    return length2;
}

/* 取得控件得绝对位置 */
function getoffset(e) {
    var t = e.offsetTop;
    var l = e.offsetLeft;
    while (e = e.offsetParent)
    {
        t += e.offsetTop;
        l += e.offsetLeft;
    }
    var rec = new Array(1);
    rec[0] = t;
    rec[1] = l;
    return rec
}

// 时间比较函数
function compare_date(sdate,edate)
{
	var arr1=sdate.value.split("-");
  	var arr2=edate.value.split("-");
 	var d1=parseInt(arr1[0]*10000) + parseInt(arr1[1]*100) + parseInt(arr1[2]*1);
 	var d2=parseInt(arr2[0]*10000) + parseInt(arr2[1]*100) + parseInt(arr2[2]*1);
 	if(parseInt(d1)>parseInt(d2))
  	{
   		return false;
  	}
	return true;
}

// 不能超过多少天
function limit_date(sdate,edate,day_num)
{
	var arr1=sdate.value.split("-");
  	var arr2=edate.value.split("-");
 	var d1=parseInt(arr1[0]*10000) + parseInt(arr1[1]*30) + parseInt(arr1[2]*1);
 	var d2=parseInt(arr2[0]*10000) + parseInt(arr2[1]*30) + parseInt(arr2[2]*1);
 	if(parseInt(d1)+day_num<parseInt(d2))
  	{
  	 	alert("开始日期和结束日期不能超过"+day_num+"天！");
   		return false;
  	}
	return true;
}

/**
 * 该方法是比较，起始号段和结束号段在信令当中的大小，结束号段必须大于起始号段 比如：86134553和86135
 * 比较出来86135是要比86134553要大的
 * 结束号段要比起始号段大才能返回true，所以start是86134553，end是86135，就能返回true 字符集编码为:UTF-8
 */
function checkTelStartEnd(start,end){
	var minlength;
	if(start.length>end.length){
		minlength = end.length;
	}else{
		minlength = start.length;
	}
	var bufstart = 0;
	var bufend = 1;
	for(i=0;i<minlength;){
		if(start.substring(bufstart,bufend) > end.substring(bufstart,bufend)){
			alert("结束号段应大于起始号段！");return false;
		}
		bufstart += 1;
		bufend += 1;
		i += 1;
	}
	return true;
}

function getPattern(pattern, patterntwo,
		 patternthree, patternfour, patternfive,
		 patselone, patseltwo, patselthree,
		 patselfour, patselfive){
	try {
		
		var titles = "<font color='red'>策略表达式：</font>";
		var str = "";
		if (pattern != null && pattern.trim()!="") {// 第一组
			str+="("+pattern+")";
			if (patselone != null && patselone!=""// 第一组间隔
					&& patselone!="0" && isNumber(patselone)==true) {
				str+=".{0,"+patselone+"}";
			} else {
				str+=".*";
			}
		}

		if (patterntwo != null && patterntwo.trim()!="") {// 第二组
			str+="("+patterntwo+")";
			if (patseltwo != null && patseltwo!=""// 第二组间隔
					&& patseltwo!="0" && isNumber(patseltwo)) {
				str+=".{0,"+patseltwo+"}";
			} else {
				str+=".*";
			}
		}

		if (patternthree != null && patternthree.trim()!="") {// 第三组
			str+="("+patternthree+")";
			if (patselthree != null && patselthree!=""// 第三组间隔
					&& patselthree!="0" && isNumber(patselthree)) {
				str+=".{0,"+patselthree+"}";
			} else {
				str+=".*";
			}
		}

		if (patternfour != null && patternfour.trim()!="") {// 第四组
			str+="("+patternfour+")";
			if (patselfour != null && patselfour!=""// 第四组间隔
					&& patselfour!="0" && isNumber(patselfour)) {
				str+=".{0,"+patselfour+"}";
			} else {
				str+=".*";
			}
		}

		if (patternfive != null && patternfive.trim()!="") {// 第五组
			str+="("+patternfive+")";
			if (patselfive != null && patselfive!=""// 第五组间隔
					&& patselfive!="0" && isNumber(patselfive)) {
				str+=".{0,"+patselfive+"}";
			} else {
				str+=".*";
			}
		}
		var lens = str.lastIndexOf(")")+1;
		if(lens>1){
			return titles+str.substring(0, lens);
		}else{
			return "<font color='red'>匹配策略不能为空，请检查</font>";
		}
	} catch (e) {
		return "<font color='red'>你的输入包含非允许字符，请检查</font>";
	}
}

