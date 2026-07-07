#ifndef PROTOCOL_H
#define PROTOCOL_H

#include <stdint.h>

/*
 * mes_machine(L1) <-> mes_equipment(L2) 사이의 통신 프로토콜
 * 원본 C# 버전과 100% 동일한 포맷을 유지한다.
 *
 * [STX 0x02][msgType 1byte][value 4byte, 리틀엔디언][ETX 0x03]  = 총 7바이트
 *
 * msgType 0x10 : 온도 데이터        (L1 -> L2)
 * msgType 0x20 : 생산실적(L1 -> L2) 또는 작업지시(L2 -> L1) - 방향에 따라 의미가 다름
 */

#define PACKET_SIZE 7
#define STX 0x02
#define ETX 0x03

#define MSG_TEMPERATURE       0x10
#define MSG_PRODUCTION_OR_ORDER 0x20

/* value를 리틀엔디언 4바이트로 직접 인코딩한다 (호스트 엔디언에 의존하지 않음) */
void packet_build(uint8_t out7[PACKET_SIZE], uint8_t msg_type, int32_t value);

/* STX/ETX가 올바른지 검사 */
int packet_validate(const uint8_t buf7[PACKET_SIZE]);

/* msgType 추출 */
uint8_t packet_get_type(const uint8_t buf7[PACKET_SIZE]);

/* value 추출 (리틀엔디언으로 직접 디코딩) */
int32_t packet_get_value(const uint8_t buf7[PACKET_SIZE]);

#endif /* PROTOCOL_H */