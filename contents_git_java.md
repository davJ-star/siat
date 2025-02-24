yaml과 yml은 동일하다.


## git revert vs git reset

- revert는 이전 커밋 내역이 남아 있다. 이미 올라가있을때는 revert를 사용하고 팀프로젝트이면, revert가 압도적으로 맞음.
- reset을 해버리면 기존것을 다 사라지게 한다.(개인 것만하는 걸로 생각하기 - 원격에서 rebase를 오케이! 원격 관리할 때 무조건 말하고 하기! + branch를 만들어서 항상 작업하기!)

## git merge vs rebase

- merge는 '한 커밋'에 이어붙인다.
- rebase는 '한 브랜치'에 이어붙인다.
