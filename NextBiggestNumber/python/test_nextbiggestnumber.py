from next_biggest_number import next_biggest_number
def test_simple_cases():
    assert(next_biggest_number(12) == 21)
    assert(next_biggest_number(123) == 132)
    assert(next_biggest_number(67809) == 67890)


def test_simple_cases_no_solution():
    assert(next_biggest_number(21) == -1)
    assert(next_biggest_number(54321) == -1)


def test_52210():
    assert(next_biggest_number(52210) == -1)


def test_95701():
    assert(next_biggest_number(95701) == 95710)


def test_71305():
    assert(next_biggest_number(71305) == 71350)


def test_6358():
    assert(next_biggest_number(6358) == 6385)


def test_25437():
    assert(next_biggest_number(25437) == 25473)


def test_49893():
    assert(next_biggest_number(49893) == 49938)


def test_76778():
    assert(next_biggest_number(76778) == 76787)


def test_2372():
    assert(next_biggest_number(2372) == 2723)


def test_45071():
    assert(next_biggest_number(45071) == 45107)


def test_31233():
    assert(next_biggest_number(31233) == 31323)


def test_50401():
    assert(next_biggest_number(50401) == 50410)


def test_57067():
    assert(next_biggest_number(57067) == 57076)


def test_40272():
    assert(next_biggest_number(40272) == 40722)


def test_54998():
    assert(next_biggest_number(54998) == 58499)


def test_22437():
    assert(next_biggest_number(22437) == 22473)


def test_53510():
    assert(next_biggest_number(53510) == 55013)


def test_78263():
    assert(next_biggest_number(78263) == 78326)


def test_42661():
    assert(next_biggest_number(42661) == 46126)


def test_45118():
    assert(next_biggest_number(45118) == 45181)


def test_26075():
    assert(next_biggest_number(26075) == 26507)


def test_93932():
    assert(next_biggest_number(93932) == 99233)


def test_84252():
    assert(next_biggest_number(84252) == 84522)


def test_33203():
    assert(next_biggest_number(33203) == 33230)


def test_98037():
    assert(next_biggest_number(98037) == 98073)


def test_74041():
    assert(next_biggest_number(74041) == 74104)


def test_11856():
    assert(next_biggest_number(11856) == 11865)


def test_47998():
    assert(next_biggest_number(47998) == 48799)


def test_36708():
    assert(next_biggest_number(36708) == 36780)


def test_93802():
    assert(next_biggest_number(93802) == 93820)


def test_2902():
    assert(next_biggest_number(2902) == 2920)


def test_71116():
    assert(next_biggest_number(71116) == 71161)


def test_76532():
    assert(next_biggest_number(76532) == -1)


def test_81848():
    assert(next_biggest_number(81848) == 81884)


def test_93493():
    assert(next_biggest_number(93493) == 93934)


def test_16332():
    assert(next_biggest_number(16332) == 21336)


def test_97939():
    assert(next_biggest_number(97939) == 97993)


def test_4386():
    assert(next_biggest_number(4386) == 4638)


def test_6950():
    assert(next_biggest_number(6950) == 9056)


def test_92232():
    assert(next_biggest_number(92232) == 92322)


def test_39527():
    assert(next_biggest_number(39527) == 39572)


def test_41766():
    assert(next_biggest_number(41766) == 46167)


def test_3399():
    assert(next_biggest_number(3399) == 3939)


def test_77957():
    assert(next_biggest_number(77957) == 77975)


def test_81899():
    assert(next_biggest_number(81899) == 81989)


def test_2403():
    assert(next_biggest_number(2403) == 2430)


def test_23817():
    assert(next_biggest_number(23817) == 23871)


def test_85520():
    assert(next_biggest_number(85520) == -1)


def test_42882():
    assert(next_biggest_number(42882) == 48228)


def test_56072():
    assert(next_biggest_number(56072) == 56207)


def test_89101():
    assert(next_biggest_number(89101) == 89110)


def test_25384():
    assert(next_biggest_number(25384) == 25438)


def test_54443():
    assert(next_biggest_number(54443) == -1)


def test_49459():
    assert(next_biggest_number(49459) == 49495)


def test_84803():
    assert(next_biggest_number(84803) == 84830)


def test_50766():
    assert(next_biggest_number(50766) == 56067)


def test_43770():
    assert(next_biggest_number(43770) == 47037)


def test_33285():
    assert(next_biggest_number(33285) == 33528)


def test_42083():
    assert(next_biggest_number(42083) == 42308)


def test_47482():
    assert(next_biggest_number(47482) == 47824)


def test_45634():
    assert(next_biggest_number(45634) == 45643)


def test_73784():
    assert(next_biggest_number(73784) == 73847)


def test_97071():
    assert(next_biggest_number(97071) == 97107)


def test_81003():
    assert(next_biggest_number(81003) == 81030)


def test_32619():
    assert(next_biggest_number(32619) == 32691)


def test_36448():
    assert(next_biggest_number(36448) == 36484)


def test_22368():
    assert(next_biggest_number(22368) == 22386)


def test_22794():
    assert(next_biggest_number(22794) == 22947)


def test_58927():
    assert(next_biggest_number(58927) == 58972)


def test_73399():
    assert(next_biggest_number(73399) == 73939)


def test_81830():
    assert(next_biggest_number(81830) == 83018)


def test_49685():
    assert(next_biggest_number(49685) == 49856)


def test_73251():
    assert(next_biggest_number(73251) == 73512)


def test_44595():
    assert(next_biggest_number(44595) == 44955)


def test_81165():
    assert(next_biggest_number(81165) == 81516)


def test_85034():
    assert(next_biggest_number(85034) == 85043)


def test_31814():
    assert(next_biggest_number(31814) == 31841)


def test_79768():
    assert(next_biggest_number(79768) == 79786)


def test_88439():
    assert(next_biggest_number(88439) == 88493)


def test_44697():
    assert(next_biggest_number(44697) == 44769)


def test_52821():
    assert(next_biggest_number(52821) == 58122)


def test_80263():
    assert(next_biggest_number(80263) == 80326)


def test_71049():
    assert(next_biggest_number(71049) == 71094)


def test_91362():
    assert(next_biggest_number(91362) == 91623)


def test_17056():
    assert(next_biggest_number(17056) == 17065)


def test_26130():
    assert(next_biggest_number(26130) == 26301)


def test_83800():
    assert(next_biggest_number(83800) == 88003)


def test_52246():
    assert(next_biggest_number(52246) == 52264)


def test_56996():
    assert(next_biggest_number(56996) == 59669)


def test_30281():
    assert(next_biggest_number(30281) == 30812)


def test_51428():
    assert(next_biggest_number(51428) == 51482)


def test_7654():
    assert(next_biggest_number(7654) == -1)


def test_33095():
    assert(next_biggest_number(33095) == 33509)


def test_50933():
    assert(next_biggest_number(50933) == 53039)


def test_7558():
    assert(next_biggest_number(7558) == 7585)


def test_75659():
    assert(next_biggest_number(75659) == 75695)


def test_36639():
    assert(next_biggest_number(36639) == 36693)


def test_75517():
    assert(next_biggest_number(75517) == 75571)


def test_64149():
    assert(next_biggest_number(64149) == 64194)


def test_44926():
    assert(next_biggest_number(44926) == 44962)


def test_16230():
    assert(next_biggest_number(16230) == 16302)


def test_36166():
    assert(next_biggest_number(36166) == 36616)


def test_14134():
    assert(next_biggest_number(14134) == 14143)


def test_66848():
    assert(next_biggest_number(66848) == 66884)


def test_85420():
    assert(next_biggest_number(85420) == -1)


def test_6447():
    assert(next_biggest_number(6447) == 6474)


def test_70690():
    assert(next_biggest_number(70690) == 70906)


def test_55511():
    assert(next_biggest_number(55511) == -1)


def test_55224():
    assert(next_biggest_number(55224) == 55242)


def test_73239():
    assert(next_biggest_number(73239) == 73293)


def test_21166():
    assert(next_biggest_number(21166) == 21616)


def test_69958():
    assert(next_biggest_number(69958) == 69985)


def test_59609():
    assert(next_biggest_number(59609) == 59690)


def test_28850():
    assert(next_biggest_number(28850) == 50288)


def test_34085():
    assert(next_biggest_number(34085) == 34508)


def test_68686():
    assert(next_biggest_number(68686) == 68866)


def test_30015():
    assert(next_biggest_number(30015) == 30051)


def test_95116():
    assert(next_biggest_number(95116) == 95161)


def test_68150():
    assert(next_biggest_number(68150) == 68501)


def test_80403():
    assert(next_biggest_number(80403) == 80430)


def test_32154():
    assert(next_biggest_number(32154) == 32415)


def test_34731():
    assert(next_biggest_number(34731) == 37134)


def test_18099():
    assert(next_biggest_number(18099) == 18909)


def test_13447():
    assert(next_biggest_number(13447) == 13474)


def test_56296():
    assert(next_biggest_number(56296) == 56629)


def test_1276():
    assert(next_biggest_number(1276) == 1627)


def test_44944():
    assert(next_biggest_number(44944) == 49444)


def test_75519():
    assert(next_biggest_number(75519) == 75591)


def test_45632():
    assert(next_biggest_number(45632) == 46235)


def test_27590():
    assert(next_biggest_number(27590) == 27905)


def test_7251():
    assert(next_biggest_number(7251) == 7512)


def test_90251():
    assert(next_biggest_number(90251) == 90512)


def test_98728():
    assert(next_biggest_number(98728) == 98782)


def test_51811():
    assert(next_biggest_number(51811) == 58111)


def test_59358():
    assert(next_biggest_number(59358) == 59385)


def test_24098():
    assert(next_biggest_number(24098) == 24809)


def test_59176():
    assert(next_biggest_number(59176) == 59617)


def test_54917():
    assert(next_biggest_number(54917) == 54971)


def test_8165():
    assert(next_biggest_number(8165) == 8516)


def test_34178():
    assert(next_biggest_number(34178) == 34187)


def test_71652():
    assert(next_biggest_number(71652) == 72156)


def test_26168():
    assert(next_biggest_number(26168) == 26186)


def test_49396():
    assert(next_biggest_number(49396) == 49639)


def test_78946():
    assert(next_biggest_number(78946) == 78964)


def test_33316():
    assert(next_biggest_number(33316) == 33361)


def test_15484():
    assert(next_biggest_number(15484) == 15844)


def test_2211():
    assert(next_biggest_number(2211) == -1)


def test_97203():
    assert(next_biggest_number(97203) == 97230)


def test_70956():
    assert(next_biggest_number(70956) == 70965)


