class BookingFacade {
    private HotelAPI hotelAPI;
    private PaymentService paymentService;

    public BookingFacade() {
        this.hotelAPI = new HotelAPI();
        this.paymentService = new PaymentService();
    }

    public void reservarHabitacion(String usuario, String hotel, double monto) {
        hotelAPI.buscarHotel(hotel);
        paymentService.procesarPago(usuario, monto);
        System.out.println("Reserva completada para: " + usuario);
    }

}
