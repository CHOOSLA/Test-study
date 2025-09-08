import java.util.Arrays;

/**
 * IntelliJ 실무에서 주로 사용하는 단축키 정리
 *
 * [코드 선택 및 편집]
 * - 행 맨 처음/끝 이동 : cmd + 방향키
 * - 단어 단위 이동 : option + 방향키
 * - 코드 블록 지정(범위 선택) : shift + 이동
 * - 캐럿(커럿) 사이 이동 : option + 방향키
 * - 한 줄 주석 : cmd + /
 * - 블록 주석 : cmd + option + /
 * - 행 삭제 : cmd + backspace
 * - 코드 접기/풀기 : cmd + -, cmd + +  또는 cmd + .
 * - 파일 전체 접기/풀기 : cmd + shift + +, cmd + shift + -
 * - 문장(라인) 이동 : option + shift + ↑/↓
 * - 메서드 단위 이동 : cmd + shift + ↑/↓
 * - 코드 자동완성(완료) : shift + cmd + enter
 * - 커서 뒤 공백 삭제 : backspace
 * - 코드 스타일 포맷팅 : cmd + option + L
 * - 선택 블록 감싸기(Surround With) : cmd + option + T
 * - 선택 영역 정리(단어/구간 삭제) : option + backspace
 * - 안 쓰는 import 정리 : ctrl + option + O
 * - 마우스 없이 기본 자동완성 : ctrl + space  // mac 기본 단축키와 충돌 시 시스템 설정 해제 필요
 *
 * [빠른 실행]
 * - 전체 액션 검색(Find Action) : shift + cmd + A
 * - 컨텍스트 액션(의존성 추가 등) : option + enter
 * - 라이브 템플릿 삽입 : cmd + J
 *
 * [리팩토링]
 * - 리팩토링 팝업 : ctrl + T
 * - 지역 변수로 빼기 : cmd + option + V
 * - 메서드로 빼기 : cmd + option + M
 * - 매개변수로 바꾸기 : cmd + option + P
 * - 상수로 빼기 : cmd + option + C
 *
 * [창 관리]
 * - 프로젝트 창 : cmd + 1
 * - 실행(런) 탭 : cmd + 4
 * - 터미널 창 : option + F12
 * - 활성 창 강제 닫기 : shift + ESC
 * - 서브창/에디터 탭 닫기 : cmd + W
 * - 프로그램 종료 : cmd + Q
 * - 문서 보기 : F1
 * - 다음 오류/경고로 이동 : F2
 *
 * [실행 및 디버깅]
 * - 실행 : ctrl + R
 * - 디버깅 : ctrl + D
 *
 * [검색 및 바꾸기]
 * - 전체 검색(검색 Everywhere) : shift + shift
 * - 클래스 찾기 : cmd + O
 * - 전체 파일에서 찾기 : cmd + shift + F
 * - 현재 파일에서 찾기 : cmd + F
 * - 전체 찾아 바꾸기 : cmd + shift + R
 */

// ctrl + option + O : 임포트 정리
// shift + esc : 활성 기능 창 닫기
// cmd + option + shift + L : 코드 정리
// shift + shift : 전체 검색
// F2 : 파일 내 강조 표시된 다음 오류(워닝)으로 넘어간다.
// cmd + shift + F : 전체 파일에서 코드 찾기

class Welcome {
    // cmd + Enter : 아래에 개행 문자 추가
    // 추가된 모습

    public static void main(String[] args) {
        // 커맨드 누르고 메서드 호출부 클릭 : 정의부로 이동
        int[] array = {5, 6, 7, 8};

        // F1 : 도큐먼트 보기
        System.out.printf("AVERAGE of array %s is %s%n", Arrays.toString(array), findAverage(array));

        // cmd + p : 어떤 파라미터를 받을 수 있는지 확인
        System.out.println();
    }

    // cmd + B : 정의부, 사용부로 이동
    private static double findAverage(int[] values) {
        double result = 0;
        for (int value : values) {
            result += value;
        }
        return result / values.length;
    }
}