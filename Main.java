import java.util.Scanner;

public class Main {

    static int edad;
    static String nombre;
    static Scanner key = new Scanner(System.in);
    static boolean influenza,edadriesgo,diabetes,cancer,sida,asma,obesidad,hepatitis,contacto;
    static int puntos = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n\nVamos a realizarle unas pequeñas preguntas para asesorarle durante el confinamiento y para saber si es seguro que salga a la calle a partir de la fase 1.\n\n Respóndalas del siguiente modo:\n\n1. Si la respuesta es sí, introduzca un 1.\nSi la respuesta es no, introduzca un 2\nSi se le pide otro valor, introdúzcalo.");
        Thread.sleep(5000);
        preguntarNombre();
        Thread.sleep(500);
        System.out.println("Un placer, " + nombre + ".");
        preguntarEdad();
        Thread.sleep(500);
        preguntarDiabetes();
        Thread.sleep(500);
        preguntarCancer();
        Thread.sleep(500);
        preguntarSida();
        Thread.sleep(500);
        preguntarAsma();
        Thread.sleep(500);
        preguntarObesidad();
        Thread.sleep(500);
        preguntarHepatitis();
        Thread.sleep(500);
        contacto();
        Thread.sleep(500);
        resultadosFinales();
        Thread.sleep(1000);
        recomendacion();
    }


    public static void preguntarNombre() {
        System.out.println("Antes de comenzar, para hacer más ameno el uso del programa nos gustaría que nos contase un poco sobre usted. ¿Cuál es su nombre?");
        nombre = key.next();
        key.nextLine();
    }

    public static void preguntarEdad() {
        System.out.println("¿Qué edad tiene?");
        edad = key.nextInt();
        if (edad > 65) {
            influenza = true;
            edadriesgo = true;
            puntos += 45;
        } else {
            influenza = false;
            edadriesgo = false;
        }
    }

    public static void preguntarDiabetes() {
        System.out.println("¿Tiene usted diabetes?   Responda con 1=Sí, 2=No");
        int respuesta = key.nextInt();
        switch (respuesta) {
            case 1:
                diabetes = true;
                puntos +=2;
                break;
            case 2:
                diabetes = false;
                break;
            default:
                System.out.println("Responda una de las dos opciones.");
                preguntarDiabetes();
                break;
        }
    }

    public static void preguntarCancer() {
        System.out.println("¿Sufre usted de, o ha superado algún cáncer en los últimos 10 años?");
        int respuesta = key.nextInt();
        switch (respuesta) {
            case 1:
                cancer = true;
                puntos +=15;
                break;
            case 2:
                cancer = false;
                break;
            default:
                System.out.println("Responda una de las dos opciones.");
                preguntarCancer();
                break;
        }
    }

    public static void preguntarSida() {
        System.out.println("¿Padece usted de VIH?");
        int respuesta = key.nextInt();
        switch (respuesta) {
            case 1:
                sida = true;
                if(!cancer){
                    puntos+=15;
                }
                break;
            case 2:
                sida = false;
                break;
            default:
                System.out.println("Responda una de las dos opciones.");
                preguntarSida();
                break;
        }
    }

        public static void preguntarAsma(){
            System.out.println("¿Tiene asma?");
            int respuesta = key.nextInt();
            switch (respuesta) {
                case 1:
                    asma = true;
                    puntos+=25;
                    break;
                case 2:
                    asma = false;
                    break;
                default:
                    System.out.println("Responda una de las dos opciones.");
                    preguntarAsma();
                    break;
            }
        }

        public static void preguntarObesidad(){
            System.out.println("¿Es usted obeso o padece de obesidad?");
            int respuesta = key.nextInt();
            switch (respuesta) {
                case 1:
                    obesidad = true;
                    puntos+=20;
                    break;
                case 2:
                    obesidad = false;
                    break;
                default:
                    System.out.println("Responda una de las dos opciones.");
                    preguntarObesidad();
                    break;
            }
        }

        public static void preguntarHepatitis(){
            System.out.println("¿Padece usted de cualquier tipo de hepatitis, cirrosis o sufre de cualquier otra enfermedad hepática?");
            int respuesta = key.nextInt();
            switch (respuesta) {
                case 1:
                    hepatitis = true;
                    puntos+=15;
                    break;
                case 2:
                    hepatitis = false;
                    break;
                default:
                    System.out.println("Responda una de las dos opciones.");
                    preguntarHepatitis();
                    break;
            }
        }

        public static void contacto(){
            System.out.println("¿Ha estado en contacto con personas afectadas por COVID-19, o doctores, enfermeros, o cualquier otro personal que trate con afectados?");
            int respuesta = key.nextInt();
            switch (respuesta) {
                case 1:
                    contacto = true;
                    puntos+=25;
                    break;
                case 2:
                    contacto = false;
                    break;
                default:
                    System.out.println("Responda una de las dos opciones.");
                    preguntarHepatitis();
                    break;
            }
        }











        public static void resultadosFinales () {
            System.out.println("Estas son las recomendaciones personalizadas para usted, " + nombre + ":");
            if (edadriesgo) {
                System.out.println("Al ser una persona mayor de 65 años se le considera en edad de alto riesgo, por lo cual corre más riesgo de enfermar gravemente a causa del COVID-19.\n\nEs recomendable que tome las siguientes medidas:\n" +
                        "- Tome sus medicamentos para cualquier afección subyacente que tenga siguiendo todas las indicaciones.\n-Siga las indicaciones de su proveedor de atención médica.\nCree un plan de cuidado que resuma sus afecciones y tratamientos actuales.\nPrepárese para quedarse en casa por periodos prolongados.\n\nPor su seguridad, evite salir lo máximo posible de casa\n\n\n");
            }

            if (diabetes) {
                System.out.println("Las personas con diabetes cuyos niveles de azúcar en la sangre suelen ser más elevados que su objetivo. Esto dificulta más recuperarse del COVID-19. Le reocomendamos que:\n\n-Siga tomando sus pastillas para la diabetes y su insulina como lo hace normalmente.\n- Mida sus niveles de azúcar en sangre cada cuatro horas y mantenga un registro de los resultados. " +
                        "\n-Procure tener un suministro para al menos dos semanas de sus medicamentos para la diabetes e insulina.\n\n\n");
            }


            if (cancer || sida){
                System.out.println("Las personas inmunodeprimidas (Personas con tratamiento activo contra el cáncer o VIH, o transplantes de médula ósea) tienen menor capacidad para combatir las enfermedades infecciosas, incluidos los virus como el COVID-19. Le recomendamos que:\n" +
                        "-siga tomando los medicamentos recomendados y siga los tratamientos indicados y los consejos de su proveedor de atención médica.\n-Llame a su proveedor de atención médica si le preocupa su afección o se siente enfermo.\n\n\n");
            }

            if (asma){
                System.out.println("El COVID-19 puede afectar sus vías respiratorias (nariz, garganta, pulmones), causarle un ataque de asma y posiblemente provocarle una neumonía y enfermarlo gravemente. Por favor, siga estas instrucciones con la mayor rigidez posible:\n" +
                        "-Mantenga bajo control su problema de asma.\n-Siga su plan de acción para el asma.-Siga utilizando su medicamento actual, incluidos los inhaladores con esteroides (\"esteroides\" es otra denominación de corticoesteroides).\n-Evite los  factores que desencadenan su asma.\n-Si es posible, pida a otro integrante de su hogar que no tenga asma que limpie y desinfecte su casa por usted.\n-Mientras utilicen productos de limpieza, manténgase alejado.\n\n\n");
            }

            if(obesidad){
                System.out.println("La obesidad grave aumenta el riesgo de un problema grave para respirar que se llama síndrome de distrés respiratorio agudo (SDRA), que es una complicación grave del COVID-19 que puede dificultar a los médicos dar apoyo respiratorio a los pacientes muy enfermos. Las personas que viven con obesidad grave pueden tener diversas enfermedades crónicas y subyacentes graves que pueden aumentar su riesgo de enfermarse gravemente a causa del COVID-19. Se recomienda que tome sus medicamentos para cualquier afección subyacente que tenga siguiendo todas las indicaciones.\n\n\n");
            }

            if(hepatitis){
                System.out.println("Las enfermedades hepáticas crónicas, incluida la cirrosis, pueden aumentar el riesgo de enfermarse gravemente a causa del COVID-19.\n-Tome sus medicamentos siguiendo estrictamente las indicaciones.\n\n\n");
            }

            if(contacto){
                System.out.println("Se recomienda que usted y sus cercanos permanezcan confinados durante los próximos 21 días. En caso de padecer síntomas relacionados con el COVID-19, por favor acuda a urgencias. Evite el contacto con el exterior y personas más cercanas.");
            }
        }

        public static void recomendacion(){
            System.out.println("Teniendo en cuenta este cuestionario, y las preguntas que ha elegido usted, "+nombre+":\n\n");

            if(puntos<10){
                System.out.println("Puedes salir con normalidad a la calle, siguiendo las normativas de seguridad que establezca el gobierno. Recuerda que el uso de mascarilla es obligatorio.");
            }
            if(puntos>=10 && puntos<30){
                System.out.println("Es recomendable por su salud evitar contagiarse por covid. Evita las aglomeraciones y la prolongada estancia en exteriores. Sal solo por necesidad.");
            }

            if(puntos>=30 && puntos<50){
                System.out.println("No se recomienda que salgas, a ser posible solicite a terceros la realización de tareas de primera necesidad, como hacer la compra o ir a la farmacia. En caso extremo, hágalo usted mismo extremando al máximo las medidas de seguridad. Su salud está en juego.");
            }

            if(puntos>=50){
                System.out.println("Por favor, quédese en casa. Usted se encuentra en los grupos de personas con mayor riesgo de enfermarse GRAVEMENTE por COVID-19. Por favor, extreme la precaución:\n\nSiga tomando sus medicamentos y no modifique su plan de tratamiento sin consultar a su médico.\nTenga un suministro para al menos 2 semanas de sus medicamentos recetados y de venta sin receta médica. Hable con su proveedor de atención médica, su asegurador y su farmacéutico acerca de la posibilidad de obtener un suministro adicional (es decir, para más de dos semanas) de sus medicamentos recetados, en la medida de lo posible para reducir la cantidad de veces que debe ir a la farmacia." +
                        "\nConsulte a su proveedor de atención médica si tiene sus vacunas al día. Se recomienda que las personas de 65 años de edad o más y quienes tienen muchas afecciones subyacentes, como las personas con el sistema inmunitario deprimido o con una enfermedad hepática grave, se vacunen contra la influenza y el neumococo." +
                        "\nLlame a su proveedor de atención médica si tiene alguna inquietud acerca de sus afecciones subyacentes o si se enferma y cree que podría tener COVID-19. Si necesita ayuda de emergencia, llame al 911." +
                        "\nNo demore la solicitud de atención de emergencia para su afección subyacente a causa del COVID-19. Los departamentos de emergencia tienen planes de contingencia para la prevención de infecciones, diseñados para protegerlo del COVID-19 si necesita atención para su afección subyacente." +
                        "\n\nManténgase alejado de otras personas tanto como sea posible, y quédese en casa.");
            }
        }
    }
