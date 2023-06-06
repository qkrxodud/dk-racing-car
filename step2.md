1. merge를 완료했다는 통보를 받으면 브랜치 변경 및 작업 브랜치 삭제(option)한다.

```cvs
git checkout 본인_아이디
git branch -D 삭제할_브랜치이름
ex) git checkout bella
ex) git branch -D step1

```

2. 통합(merge)한 qkrxodud 저장소와 동기화하기 위해 qkrxodud 저장소 추가(최초 한번만)
```cvs
git remote add {저장소_별칭} base_저장소_url
ex) git remote add upstream https://github.com/qkrxodud/dk-racing-car.git
// 위와 같이 저장소를 추가한 후 전체 remote 저장소 목록을 본다.
git remote -v 
```

3. 저장소에서 자기 브랜치 가져오기(또는 갱신하기) 
```cvs
git fetch upstream {본인_아이디}
ex) git fetch upstream bella

```

4. 저장소 브랜치와 동기화하기
```cvs
git rebase upstream/본인_아이디
ex) git rebase upstream/bella
```


5. 새로운 미션을 진행하기 위한 브랜치 생성
```cvs
git checkout -b 브랜치이름
ex) git checkout -b step2
```
