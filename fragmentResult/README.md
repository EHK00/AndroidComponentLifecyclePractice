### fragment result api에서 중복된 requestKey 관리

setFragmentResultListener을 호출하는 시점에 따라 fragment result 수신 여부를 테스트 합니다.

## 클래스 설명

ResultFragment:
Fragment result를 등록하고 popbackstack을 수행합니다.

FragmentA:
ResultFragment, FragmentB로 화면 전환을 시도하거나 등록된 Fragment result를 보여줍니다.

FragmentB:
등록된 Fragment result를 보여줍니다.

## onCreate에서 호출하는 경우

fragment onCreate callback에서 FragmentResultListener를 등록하는 사례입니다.

[공식 홈페이지 가이드](https://developer.android.com/guide/fragments/communicate#pass-between-fragments)
에서 제공하는 방법으로 수행합니다.

FragmentA -> FragmentB -> ResultFragment -> back to FragmentB(O) -> back to FragmentA ->
ResultFragment -> back to FragmentA(X)

setFragmentResultListener() 이 호출되면 기존에 등록된 requestKey로 fragmentResultListener가 덮어씌워지기 때문에 새로운 결과를 받을
수 없습니다.

## onViewCreated에서 호출하는 경우

fragment onViewCreated callback에서 FragmentResultListener를 등록하는 사례

FragmentA -> FragmentB -> ResultFragment -> back to FragmentB(O) -> back to FragmentA ->
ResultFragment -> back to FragmentA(O)

가장 마지막에 생성된 fragmentView로 fragmentResultListener가 덮어씌워지기 때문에 새로운 결과를 받을 수 있습니다.

## 기타

만약 여러 fragment가 동시에 생성되는 경우에는 어떻게 처리할 수 있을까요?

FragmentResultListener 키를 관리하는 mResultListeners 객체는 fragmentManager마다 생성되며, fragment result에 대한 리스너는
한번 결과를 전달하면 해제됩니다.

복잡한 fragment container 구조에선 childFragmentManager을 이용하거나, activity 또는 viewModel 등의 중간자를 이용하여 대응하는 것을
권장합니다.
