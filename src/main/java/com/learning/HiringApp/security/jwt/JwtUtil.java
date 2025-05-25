@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET;

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(User user) {
        final long EXPIRES_IN = 1000 * 60 * 60;

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId().toString())
                .claim("role", user.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN))
                .signWith(getSecretKey())
                .compact();
    }

    public String extractUsername(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public boolean validateToken(String username, UserDetails userDetails, String token) {
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
