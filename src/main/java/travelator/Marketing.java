package travelator;

public class Marketing {

    // domain 프로퍼티를 선언하면 코틀린 컴파일러가 비공개 domain 필드와 getDomain() 접근자 메서드를 생성해 준다.
    public static boolean isHotmailAddress(EmailAddress email){
        return email.getDomain().equalsIgnoreCase("hotmail.com");
    }
}
