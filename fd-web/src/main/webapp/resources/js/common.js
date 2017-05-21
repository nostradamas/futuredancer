// 获取分页页数
function getPageLists(current, length, displayLength) {  
	var indexes = [];  
	var start = Math.round(current - displayLength / 2);  
	var end = Math.round(current + displayLength / 2);  
    if (start <= 1) {  
        start = 1;  
        end = start + displayLength - 1;  
       if (end >= length - 1) {  
           end = length - 1;  
        }  
    }  
    if (end >= length - 1) {  
       end = length;  
        start = end - displayLength + 1;  
       if (start <= 1) {  
           start = 1;  
        }  
    }  
    for (var i = start; i <= end; i++) {  
        indexes.push(i);  
    } 
    return indexes;  
  };  
  
