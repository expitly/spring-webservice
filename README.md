## Toy
[![Build Status](https://travis-ci.org/expitly/toy.svg?branch=master)](https://travis-ci.org/expitly/toy)

- H2 -> MySQL로 변경
  - AWS RDS를 쓸 것이기 때문
  - test시에는 그냥 H2 사용함, 귀찮.
- JPA, JOOQ 사용
  - QueryDSL은 써봤으나 JOOQ는 안써봤기때문ㅋㅋ
  - SpringBoot에 포함되어있길래.. 의미가 있기를..
- TravisCI 적용.
  - 설정 간단함. 
  - GITHUB과 매우 연동 잘됨.
- AWS CodeDeploy 적용
- 배포 프로세스
  - github master branch push
  - travis ci 에서 webhook 받음
    - github이랑 travis-cli 연동해서 repository 등록해주면 자동 webhook 연동됨
  - travis ci에서 빌드 실행
  - 빌드 결과물 AWS S3에 저장
  - AWS CodeDeploy에서 배포 실행
    - S3 -> EC2로 빌드 결과 배포
    - EC2에서 application 배포 스크립트 실행
  - 끝

- 자동배포 적용하면서 DB설정 관련 정보 property 파일에 string으로 박혀있던 거 system 변수에 등록해두고 가져와서 쓰도록 변경함

  - 이유 : property에 작성해둘 경우 github에 공개됨


### 이슈 정리

- springBoot 2로 버전 올리면서 JPA관련 이슈 발생
  - 이슈 : JPA에 PK 잡을때, GnenratedValue AUTO로 했을때, 원래 auto increment되는 값이 생성됐는데 별도 테이블이 생성되어 관리됨
  - 원인 : springBoot 2 버전 업되면서 AUTO일 경우 키 생성 전략이 달라졌다함.
    - SpringBoot 1.5 : spring.jpa.properties.hibernate.id.new_generator_mappings = false
    - SpringBoot 2.0 : spring.jpa.properties.hibernate.id.new_generator_mappings = true
  - 해결 : new_generator_mappings = false 로 설정 추가



### To Do

- 테스트 커버리지 측정 툴 적용