# 프로그래머스 정렬 H-Index

* 정렬 문제이나, 정렬을 사용하지 않고도 풀리는 것 같음
* 문제 설명 
  * 과학자가 발표한 논문 n편(=citations.length) 중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 이 과학자의 H-index 는 h이다.
* citations 배열을 어떤 기준점을 잡고 비교하여야 할지,answer를 어떻게 생각해야 할지에 대한 고민을 많이 함
* 복잡할 필요없이 h=0으로 잡고 h+1에 대해 비교하며 answer를 추가하고 그 answer을 다시 h+1과 비교하여 값이 같을 때 answer값을 리턴하는 형식으로 코드를 짰음

~~~ java
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int h = 0;            
     while(h<citations.length){          
         for(int i=0;i<citations.length;i++){
            if(citations[i]>=h+1){
                answer++;
            }
        }
      // 위에서 얻은 answer 값을 아래서 비교하여 while문에서 나올지 
      // 재시행할지 판단하기 위한 코드
            if(answer==h+1){
                break;
            }else {
                answer=0;
                h++;
            }            
        }           
        return answer;          
    }
}
~~~

* 아직 한 케이스(11번)이 해결되지 않음. 이에 대해서 고민해볼 필요가 있다.