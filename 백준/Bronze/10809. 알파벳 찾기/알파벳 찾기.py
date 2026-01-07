"""
Docstring for 01문자열.알파벳찾기
소문자 단어 S
알파벳 전체에 대해 (아스키 사용?)
포함 -> 첫 등장 위치 (find 사용)
미포함 -> -1 (find default)
"""

import sys
input = sys.stdin.readline

S = input().strip()
startNum = ord("a")
endNum = ord("z")

result = []
for i in range(startNum, endNum+1):
    result.append(S.find(chr(i)))

for i in result:
    print(i, end = " ")

