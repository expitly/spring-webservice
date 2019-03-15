## Toy

[![Build Status](https://travis-ci.org/expitly/spring-webservice.svg?branch=master)](https://travis-ci.org/expitly/spring-webservice)

- H2 -> MySQL로 변경
  - AWS RDS를 쓸 것이기 때문
- JPA, JOOQ 사용
  - QueryDSL은 써봤으나 JOOQ는 안써봤기때문ㅋㅋ
  - SpringBoot에 포함되어있길래.. 의미가 있기를..



- springBoot 2로 버전 올리면서 JPA관련 이슈 발생
  - 이슈 : JPA에 PK 잡을때, GnenratedValue AUTO로 했을때, 원래 auto increment되는 값이 생성됐는데 별도 테이블이 생성되어 관리됨
  - 원인 : springBoot 2 버전 업되면서 AUTO일 경우 키 생성 전략이 달라졌다함.
    - SpringBoot 1.5 : spring.jpa.properties.hibernate.id.new_generator_mappings = false
    - SpringBoot 2.0 : spring.jpa.properties.hibernate.id.new_generator_mappings = true
  - 해결 : new_generator_mappings = false 로 설정 추가

