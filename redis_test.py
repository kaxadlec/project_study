import tkinter as tk
import redis

try:
    conn = redis.Redis(host='127.0.0.1', port=6379)

    def is_prime(n) -> bool:  # 타입힌트
        """
        소수판정함수
        :param n: 입력 정수
        :return: True(소수일 때) 또는 False(소수가 아닐때)
        """
        if n < 2:
            return False
        else:
            for i in range(2, n):
                if n % i == 0:
                    return False
        return True


    def inout_process() -> None:
        """
        입력 값을 레디스에서 가져온 후 처리 출력
        :param n:
        :return: void
        """

        number = int(conn.get('number'))
        texts = ''
        if is_prime(number):
            texts = f'{number} is Prime number'
        else:
            texts = f'{number} is NOT Prime nubmer'

        lbl_result.config(text=texts)


    def inout_process_enter_key(ev):
        inout_process()


    main_window = tk.Tk()  # 윈도우 객체 생성
    main_window.title('Front 02')
    main_window.geometry('480x300')

    # en_input_number = tk.Entry(main_window)  # 입력 상자 객체 생성
    btn_isprime = tk.Button(main_window, text='판별', command=inout_process)
    lbl_result = tk.Label(main_window, text='소수 판정 여부 출력 테이블 ')

    # en_input_number.bind("<Return>", inout_process_enter_key)  # 키보드 엔터키로 자동클릭되게하기
    # 이벤트 바인딩 -> 엔터키 인터럽트 이벤트

    # Layout (pack, grid, place)
    # en_input_number.pack(fill='x')
    lbl_result.pack()
    btn_isprime.pack(fill='x')

    # en_input_number.focus()  # 커서 자동으로 가게하기

    main_window.mainloop()


except ConnectionRefusedError as err:
    print('서버에 접속 불가')
except redis.exceptions.ConnectionError as err:
    print('레디스 서버에 접속 불가')
except ConnectionError as err:
    print('1')
except:
    print('예외발생')


print(conn.get('univ'))
conn.setex('sf', 60, 'smart factory')
print(conn.get('bootcamp'))
print(conn.get('sf'))