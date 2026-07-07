#include "protocol.h"

void packet_build(uint8_t out7[PACKET_SIZE], uint8_t msg_type, int32_t value)
{
    uint32_t v = (uint32_t)value;

    out7[0] = STX;
    out7[1] = msg_type;
    out7[2] = (uint8_t)(v & 0xFF);
    out7[3] = (uint8_t)((v >> 8) & 0xFF);
    out7[4] = (uint8_t)((v >> 16) & 0xFF);
    out7[5] = (uint8_t)((v >> 24) & 0xFF);
    out7[6] = ETX;
}

int packet_validate(const uint8_t buf7[PACKET_SIZE])
{
    return (buf7[0] == STX) && (buf7[6] == ETX);
}

uint8_t packet_get_type(const uint8_t buf7[PACKET_SIZE])
{
    return buf7[1];
}

int32_t packet_get_value(const uint8_t buf7[PACKET_SIZE])
{
    uint32_t v = (uint32_t)buf7[2]
               | ((uint32_t)buf7[3] << 8)
               | ((uint32_t)buf7[4] << 16)
               | ((uint32_t)buf7[5] << 24);
    return (int32_t)v;
}