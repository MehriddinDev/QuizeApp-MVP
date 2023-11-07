package uz.gita.quizeappmvpmehriddins.repository;

import android.util.Log;

import uz.gita.quizeappmvpmehriddins.model.TestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppRepasitory {
    private int correctCount = 0;
    private int wrongCount = 0;

    private LocalStorage localStorage;
    private int pos;
    private int skippedCount = 0;
    List<TestData> myTests;
    private static AppRepasitory repasitory;

    private AppRepasitory() {
        myTests = new ArrayList<>();
        localStorage = LocalStorage.getInstance();
    }

    public static AppRepasitory getInstance() {
        if (repasitory == null)
            repasitory = new AppRepasitory();
        return repasitory;
    }

    public void loadTestsByPos(int pos) {
        myTests.clear();
        this.pos = pos;
        switch (pos) {
            case 2:
                myTests.add(new TestData("Faqat sonor undoshlar qatnashgan so'zlar qatorini toping.", "mosh, mos, makon", "shag'al, nog'ora, mog'or", "malol, marom, marmar", "jang, mo'g'ul, nov", "malol, marom, marmar"));
                myTests.add(new TestData("Qaysi so'z tarkibida ikki jarangli undosh orasida yuqori tor unli kelgan yopiq bo'g'in bor?", "suyuqlik", "quchoqlamoq", "ko'pburchak", "besaranjom", "quchoqlamoq"));
                myTests.add(new TestData("Bo'g'inlarga ajratish bilan asos va qo'shimchalarga ajratish teng kelmaydigan qatorni toping.", "fikrim, baxtim", "boshga, toshda", "shahri, kuchli", "faxri, aqldan", "fikrim, baxtim"));
                myTests.add(new TestData("Qaysi so'zda urg'u ikkinchi bo'g'inga tushadi?", "sakkizta", "o'quvchimiz (bizning o'quvchimiz)", "allakim", "ulama (soch)", "sakkizta"));
                myTests.add(new TestData("Qaytar bo'lsam quruq qo'l ovdan,\n" +
                        "Qora qozon qolsa qaynovdan,Ham ayrilib o'lja,\n" +
                        "ulovdan, Qarzga botar bo'lsam birovdan, Taskin\n" +
                        "berib onam yig'laydir, Qolganlari yolg'on yig'laydir. (To'ra Sulaymon)\nUshbu she’riy parchada fonetik o'zgarish asosida yozilgan so'zlar necha o'rinda qo'llangan?", "4", "2", "3", "5", "5"));
                myTests.add(new TestData("Mening bu voqeadan xabardorligimni unga ayta ko'rma.\nUshbu gapdagi so'zlar tarkibida qanday fonetik o'zgarishlar kuzatiladi?", "tovush tushishi", "tovush almashishi va tushishi", "tovush orttirilishi, tushishi, almashishi", "tovush orttirilishi", "tovush orttirilishi, tushishi, almashishi"));
                myTests.add(new TestData("Nisbat qo'shimchasi vositasida o'timsiz fe'lga aylanishi mumkin bo'lgan o'timli fe’llar berilgan qatomi aniqlang.", "yuvmoq, yayramoq", "quvonmoq, jilmaymoq", "kiymoq, taramoq", "qochmoq, yonmoq", "kiymoq, taramoq"));
                myTests.add(new TestData("Aniq nisbatdagi fe’l ishtirok etgan gapni toping.", "Osmonda xiragina kemtik oy ko'rindi.", "Salim har yili ta’tilni ona qishlog'ida o'tkazadi.", "U do'stining dov-daragini surishtirib yuribdi.", "Tushga yaqin dadam bizga ovqat keltirib berdi.", "U do'stining dov-daragini surishtirib yuribdi."));
                myTests.add(new TestData("Quyida berilgan qaysi maqolda ham o'tImli, ham o'timsiz fe’l qo'llangan?", "Eksang, o'rasan.", "Do'st achitib gapirar, dushman - kuldirib.", "Yer - to'ydirar, o't - kuydirar.", "Qunt bilan o'rgan hunar, hunardan rizqing unar", "Qunt bilan o'rgan hunar, hunardan rizqing unar"));
                myTests.add(new TestData("Ota o'g'lini o'zga yurtga safarga otlantirib, oq fotiha berarkan, «balo-qazolardan saqlaydi» degan ma’noda farzandining qo'liga non tutqazgan.\nUshbu gapda qaysi nisbatdagi fe'ilar ishtirok etgan va ularning sonini toping.", "2 ta aniq, 2 ta orttirma nisbat", "1 ta aniq, 3 ta orttirtna nisbat", "1 ta aniq, 2 fa orttirma nisbat", "3 ta orttirma nisbat", "2 ta aniq, 2 ta orttirma nisbat"));
                break;
            case 1:
                myTests.add(new TestData("O‘zbekiston hududidagi qaysi manzilgohda ilk shahar alomatlari ko‘zga tashlanadi ?", "Jarqo‘ton", "Faqir Qishloq", "Selengur", "Ko‘lbuloq", "Jarqo‘ton"));
                myTests.add(new TestData("Yevropada mashhur bo‘lgan qaysi alloma nomi XVI asrda Oydagi kraterlardan biriga berilgan?", "Abu Rayhon Beruniy", "Muso al-Xorazmiy", "Abu Nasr Farobiy", "Ahmad al-Farg‘oniy", "Ahmad al-Farg‘oniy"));
                myTests.add(new TestData("O`rta Osiyoda tuzilgan quyidagi qaysi davlatga saklar tomonidan asos solingan?", "Yunon-Baqtriya", "Dovon", "Kushon", "Qang’", "Qang’"));
                myTests.add(new TestData("Qaysi voqeadan so‘ng Jaloliddinning harbiy kuchi kuchsizlanib qoladi?", "Sind daryosi bo‘yida bo’lgan jangdan so‘ng", "Valiyon qal’asi yonida bo’lgan jangdan so‘ng", "Parvon dashtidagi g‘alabadan so‘ng", "“Cho’li Jaloliy” da bo’lgan jangdan so‘ng", "Parvon dashtidagi g‘alabadan so‘ng"));
                myTests.add(new TestData("XIV asrda Chig‘atoy xonlaridan kim birinchi bo‘lib o‘z qarorgohini Movarounnahrga ko‘chirgan?", "Kebek", "Munke", "Tug‘luq Temur", "Abulxayrxon", "Kebek"));
                myTests.add(new TestData("Mo‘g‘ulistonning qaysi ulug‘ xoqoni soliq va hashar ishlarini, tartibga solish to‘g‘risida maxsus farmon - yorliq chiqaradi?", "Ma’sudbek", "Tug’luq Temur", "Munke", "Chig‘atoy", "Munke"));
                myTests.add(new TestData("Qaysi daryo qadimda Yaksart deb atalgan?", "Sirdaryo", "Amudaryo", "Zarafshon", "Qashqadaryo", "Sirdaryo"));
                myTests.add(new TestData("VI-VII asrlarda O‘rta Osiyo aholisining asosiy qismi qaysi dinga e’tiqod qilgan?", "zardushtiylik", "moniylik", "islom", "buddaviylik", "zardushtiylik"));
                myTests.add(new TestData("Qadimgi Xorazmda shaharsozlik qachon boshlangan?", "Mil.avv VII asr", "Mil.avv Vl asr", "Mil.avv Vlll asr", "Mil.avv Xl asr", "Mil.avv VII asr"));
                myTests.add(new TestData("Tarixda “Loy jangi” nomi bilan shuhrat topgan jang nechanchi yilda bo’lib o’tgan?", "1365-yilda", "1370-yilda", "1395-yilda", "1402-yilda", "1365-yilda"));
                break;
            case 3:
                myTests.add(new TestData("Tenglamani yeching:\n\n -2x + 3 = 3x + 8", "1", "-1", "0", "2", "-1"));
                myTests.add(new TestData("To`g`ri to`rtburchakning perimetri 74 sm ga teng . Bo`yi enidan 4 sm uzun. Shu to`g`ri to`rtburchakning bo`yi va enini toping.", "20 sm; 17,6 sm", "19 sm; 20,4 sm", "27 sm; 18,4 sm", "20,5; 16,5", "20,5; 16,5"));
                myTests.add(new TestData("Bir tokchada ikkinchisiga qaraganda 3 marta ko`p kitob bor. Ikkala tokchadagi jami kitoblar soni 108 ta bo`lsa, har bir tokchada nechtadan kitob bor ?", "60; 48", "75; 33", "72; 36", "81; 27", "81; 27"));
                myTests.add(new TestData("Proporsiyaning noma’lum hadini toping:\n\n 7,5 : X = 15 : 6", "2,5", "6", "3", "4.5", "3"));
                myTests.add(new TestData("Hisoblang:\n\n |- 6 | + |- 16 |.", "10", "22", "-10", "-22", "22"));
                myTests.add(new TestData("Ombordagi ozuqa 4 ta qo`yga 12 kunga yetadi. Shu ozuqa 3 ta qo`yga necha kunga yetadi?", "9 kunga", "16 kunga", "10 kunga", "18 kunga", "9 kunga"));
                myTests.add(new TestData("Hisoblang:\n\n(-15) ∙ (-17) + (-23) ∙ 13.", "-44", "-7800", "3016", "-42", "-44"));
                myTests.add(new TestData("Ifoda qiymatini hisoblang:\n\n( 7 – (-10) – (-3)) ·(-2)", "–40", "0", "11", "23", "–40"));
                myTests.add(new TestData("Hisoblang:\n\n|- 29 | - |- 37 |.", "8", "66", "-8", "66", "-8"));
                myTests.add(new TestData("Hisoblang:\n\n(-7) + ( -32).", "39", "-25", "25", "-39", "-39"));
                break;
        }
    }

    public void shuffle() {
        Collections.shuffle(myTests);
        Log.d("TTT", myTests.size() + "");
    }

    public List<TestData> getNeedTests() {
        return myTests;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void incCorrectCount() {
        correctCount++;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void incWrongCount() {
        wrongCount++;
    }

    public int getSkippedCount() {
        return skippedCount;
    }

    public void incSkippedCount() {
        skippedCount++;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public void setWrongCount(int wrongCount) {
        this.wrongCount = wrongCount;
    }

    public void setSkippedCount(int skippedCount) {
        this.skippedCount = skippedCount;
    }

    public void saveRecords() {
        Log.d("OOO","pos" + pos);
        switch (pos) {
            case 1:
                Log.d("OOO",getCorrectCount()+"  "+localStorage.getTarixRec());
                if(localStorage.getTarixRec() < getCorrectCount())
                localStorage.saveTarixRecord(getCorrectCount());
                break;
            case 2:
                Log.d("OOO",getCorrectCount()+"  "+localStorage.getOnaTiliRec());
                if(localStorage.getOnaTiliRec() < getCorrectCount())
                    localStorage.saveOnaTiliRecord(getCorrectCount());
                break;
            case 3:
                Log.d("OOO",getCorrectCount()+"  "+ localStorage.getMatemRec());
                if(localStorage.getMatemRec() < getCorrectCount()) {
                    localStorage.saveMatemRecord(getCorrectCount());
                    Log.d("OOO","kirdi = " + pos);
                }
                break;
        }
    }

    public int[] getRecords(){
        int[] arr = new int[3];
        arr[0] = localStorage.getTarixRec();
        arr[1] = localStorage.getOnaTiliRec();
        arr[2] = localStorage.getMatemRec();
        return arr;
    }

}
