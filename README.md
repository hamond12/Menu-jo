### 화면, 기능

- **로그인**
    - 아이디 정보 마이 페이지로 전달

- **회원가입**
    - 아이디, 비밀번호 → 로그인 페이지에 전달
    - 이름, 음식 선호도 → 마이페이지로 전달
    - 음식 선호도는 라디오 버튼으로

- **마이페이지**
    - 로그아웃 기능
    - 회원가입 페이지의 데이터 전달 받기

- **메인 화면**
    - 이미지 버튼 (디테일 화면으로 라우팅)
    - 눌러보삼 → Snackbar 메시지 띄움
    - 접시 아이콘
    - 마이 페이지 전환

- **디테일 화면**
    - 스크롤 기능
    - 카테고리별 음식 리스트 출력
    - 마이 페이지 전환
    - 돌아가기

### 깃허브 규칙

feat : 새로운 기능 추가

fix : 버그 수정

chore : 그외 자잘한 수정

### 브랜치 명

```kotlin
git checkout -b feature/기능명
// feature/signin
// feature/mypage
// feature/home
// feature/category
// feature/navigation
```

### Code Convention

변수명 : 카멜케이스

함수명

- 카멜케이스
- 동사부터
- showToast()

**id값**

- 스네이크(tv_safs)

tv_confirm

TextView: tv

ImageView: iv

Button: btn

ConstraintLayout: 

EditText: et

**resources**

ic_logo.png

bg_btn_pink

**string**

ex) 버튼에 들어가는 text

→ btn_위치_기능

텍스트뷰: 위치_text
