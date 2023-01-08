package travelator

// 클래스 앞에 data modifier를 붙이면 컴파일러가 사용자가 정의 하지 않은 equals, hashCode, toString 메서드를 자동으로 대신 생성해준다.
data class EmailAddress(
    val localPart: String,  // 코틀린은 주 생성자 안에서 프로퍼티를 선언하기 때문에 한눈에 알 수 있을 정도로 더 간결하다.
    val domain: String
) {
    companion object {  // 동반 객체
        @JvmStatic
        fun parse(value: String): EmailAddress {    // 2. 문자열을 파싱해 EmailAddress를 만드는 parse라는 정적 팩토리 메서드가 있다. 이 메서드는 주 생성자를 호출한다.
            val atIndex = value.lastIndexOf("@")
            require(!(atIndex < 1 || atIndex == value.length - 1)) { "EmailAddress must be two parts separated by @" }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }
}
/*
public class EmailAddress {

    private final String localPart; // 1. 값은 불변이다. 따라서 필드를 final로 선언한다.
    private final String domain;

    public static EmailAddress parse(String value) {    // 2. 문자열을 파싱해 EmailAddress를 만드는 parse라는 정적 팩토리 메서드가 있다. 이 메서드는 주 생성자를 호출한다.
        var atIndex = value.lastIndexOf("@");
        if (atIndex < 1 || atIndex == value.length() - 1) {
            throw new IllegalArgumentException(
                "EmailAddress must be two parts separated by @"
            );
        }

        return new EmailAddress(
            value.substring(0, atIndex),
            value.substring(atIndex + 1)
        );
    }

    public EmailAddress(String localPart, String domain) {  // 3. 필드는 생성자에서 초기화된다.
        this.localPart = localPart;
        this.domain = domain;
    }

    public String getLocalPart() {  // 클래스의 프로퍼티를 구성하는 접근자 메서드는 자바빈의 명명 규칙을 따른다.
        return localPart;
    }

    public String getDomain() { // 클래스의 프로퍼티를 구성하는 접근자 메서드는 자바빈의 명명 규칙을 따른다.
        return domain;
    }

    @Override
    public boolean equals(Object o) {   // 이 클래스는 equals와 hashCode 메서드를 구현해서 모든 필드가 같을 때 두 EmailAddress 값이 같다고 판정되도록 보장한다.
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(localPart, that.localPart) && Objects.equals(domain,
            that.domain);
    }

    @Override
    public int hashCode() { // 이 클래스는 equals와 hashCode 메서드를 구현해서 모든 필드가 같을 때 두 EmailAddress 값이 같다고 판정되도록 보장한다.
        return Objects.hash(localPart, domain);
    }

    @Override
    public String toString() {  // toString은 표준 전자 우편 주소 형식을 돌려준다.
        return "EmailAddress{" +
            "localPart='" + localPart + '\'' +
            ", domain='" + domain + '\'' +
            '}';
    }
}
 */
/*
class EmailAddress(
    val localPart: String,  // 코틀린은 주 생성자 안에서 프로퍼티를 선언하기 때문에 한눈에 알 수 있을 정도로 더 간결하다.
    val domain: String
) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as EmailAddress
        return localPart == that.localPart && domain == that.domain
    }

    override fun hashCode(): Int {
        return Objects.hash(localPart, domain)
    }

    override fun toString(): String {
        return "EmailAddress{" +
                "localPart='" + localPart + '\'' +
                ", domain='" + domain + '\'' +
                '}'
    }

    companion object {  // 동반 객체
        @JvmStatic
        fun parse(value: String): EmailAddress {    // 2. 문자열을 파싱해 EmailAddress를 만드는 parse라는 정적 팩토리 메서드가 있다. 이 메서드는 주 생성자를 호출한다.
            val atIndex = value.lastIndexOf("@")
            require(!(atIndex < 1 || atIndex == value.length - 1)) { "EmailAddress must be two parts separated by @" }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }
}
 */