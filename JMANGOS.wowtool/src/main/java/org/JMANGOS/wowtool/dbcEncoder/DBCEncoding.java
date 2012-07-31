package org.JMANGOS.wowtool.dbcEncoder;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javolution.util.FastMap;

import org.JMANGOS.wowdata.dbc.dataholder.DBCDataLoader;
import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;
import org.JMANGOS.wowdata.dbc.struct.*;
import org.JMANGOS.common.threadpool.CommonThreadPoolManager;
import org.JMANGOS.common.threadpool.model.PoolStats;
import org.JMANGOS.common.threadpool.model.ThreadPoolType;

public class DBCEncoding {
	/**
	 * @param <T>
	 * @param args
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InterruptedException
	 */
	public static <T extends DBCStruct<T>> void main(String[] args)
			throws InstantiationException, IllegalAccessException,
			InterruptedException {
		boolean full = true;
		for (String string : args) {
			if (string.contains("quick")) {
				full = false;
			}
		}
		long start = System.currentTimeMillis();
		System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]")
				.format(new Date()) + " Start");
		File dir = new File("./dbc/");
		CommonThreadPoolManager threadPoolManager = new CommonThreadPoolManager();
		final FastMap<String, DBCStruct<? extends DBCStruct<?>>> list = new FastMap<String, DBCStruct<? extends DBCStruct<?>>>();
		list.put("spellshapeshiftform",
				SpellShapeshiftFormEntry.class.newInstance());
		// list.put("zonemusic", ZoneMusicEntry.class.newInstance());
		// list.put("spellicon", SpellIconEntry.class.newInstance());
		// list.put("movievariation", MovieVariationEntry.class.newInstance());
		// list.put("transportrotation",
		// TransportRotationEntry.class.newInstance());
		list.put("holidays", HolidaysEntry.class.newInstance());
		// list.put("skillcostsdata", SkillCostsDataEntry.class.newInstance());
		// list.put("powerdisplay", PowerDisplayEntry.class.newInstance());
		list.put("taxinodes", TaxiNodesEntry.class.newInstance());
		list.put("charstartoutfit", CharStartOutfitEntry.class.newInstance()); 
		// list.put("soundambience", SoundAmbienceEntry.class.newInstance());
		// list.put("destructiblemodeldata",
		// DestructibleModelDataEntry.class.newInstance());
		// list.put("lightfloatband", LightFloatBandEntry.class.newInstance());
		// list.put("cinematiccamera",
		// CinematicCameraEntry.class.newInstance());
		// list.put("spellvisual", SpellVisualEntry.class.newInstance());
		// list.put("chatprofanity", ChatProfanityEntry.class.newInstance());
		// list.put("liquidtype", LiquidTypeEntry.class.newInstance());
		// list.put("objecteffectpackageelem",
		// ObjectEffectPackageElemEntry.class.newInstance());
		// list.put("gmticketcategory",
		// GMTicketCategoryEntry.class.newInstance());
		// list.put("itemclass", ItemClassEntry.class.newInstance());
		// list.put("spellmechanic", SpellMechanicEntry.class.newInstance());
		// list.put("charsections", CharSectionsEntry.class.newInstance());
		// list.put("spelldescriptionvariables",
		// SpellDescriptionVariablesEntry.class.newInstance());
		// list.put("creaturesounddata",
		// CreatureSoundDataEntry.class.newInstance());
		// list.put("vehicleseat", VehicleSeatEntry.class.newInstance());
		// list.put("locktype", LockTypeEntry.class.newInstance());
		list.put("areatrigger", AreaTriggerEntry.class.newInstance()); 
		// list.put("charhairgeosets",
		// CharHairGeosetsEntry.class.newInstance());
		// list.put("liquidmaterial", LiquidMaterialEntry.class.newInstance());
		// list.put("charvariations", CharVariationsEntry.class.newInstance());
		// list.put("skilllinecategory",
		// SkillLineCategoryEntry.class.newInstance());
		// list.put("vehicleuiindseat",
		// VehicleUIIndSeatEntry.class.newInstance());
		list.put("itemrandomproperties",
				ItemRandomPropertiesEntry.class.newInstance());
		list.put("spellradius", SpellRadiusEntry.class.newInstance());
		list.put("bankbagslotprices",
				BankBagSlotPricesEntry.class.newInstance());
		// list.put("loadingscreens", LoadingScreensEntry.class.newInstance());
		// list.put("spammessages", SpamMessagesEntry.class.newInstance());
		list.put("soundentries", SoundEntriesEntry.class.newInstance());
		// list.put("attackanimtypes",
		// AttackAnimTypesEntry.class.newInstance());
		list.put("auctionhouse", AuctionHouseEntry.class.newInstance());
		// list.put("namesreserved", NamesReservedEntry.class.newInstance());
		// list.put("dungeonmapchunk",
		// DungeonMapChunkEntry.class.newInstance());
		// list.put("gametips", GameTipsEntry.class.newInstance());
		// list.put("gtcombatratings",
		// gtCombatRatingsEntry.class.newInstance());
		// list.put("worldstateui", WorldStateUIEntry.class.newInstance());
		// list.put("spellchaineffects",
		// SpellChainEffectsEntry.class.newInstance());
		// list.put("holidaynames", HolidayNamesEntry.class.newInstance());
		 list.put("creaturemodeldata",
		 CreatureModelDataEntry.class.newInstance());
		// list.put("cinematicsequences",
		// CinematicSequencesEntry.class.newInstance());
		list.put("glyphslot", GlyphSlotEntry.class.newInstance());
		list.put("stableslotprices", StableSlotPricesEntry.class.newInstance()); 
		// list.put("declinedwordcases",
		// DeclinedWordCasesEntry.class.newInstance());
		list.put("map", MapEntry.class.newInstance());
		// list.put("environmentaldamage",
		// EnvironmentalDamageEntry.class.newInstance());
		list.put("totemcategory", TotemCategoryEntry.class.newInstance());
		list.put("creaturetype", CreatureTypeEntry.class.newInstance());
		// list.put("helmetgeosetvisdata",
		// HelmetGeosetVisDataEntry.class.newInstance());
		// list.put("itemcondextcosts",
		// ItemCondExtCostsEntry.class.newInstance());
		// list.put("gtregenhpperspt",
		// gtRegenHPPerSptEntry.class.newInstance());
		// list.put("achievement_category",
		// Achievement_CategoryEntry.class.newInstance());
		list.put("talent", TalentEntry.class.newInstance());
		// list.put("itemvisualeffects",
		// ItemVisualEffectsEntry.class.newInstance());
		// list.put("currencycategory",
		// CurrencyCategoryEntry.class.newInstance());
		// list.put("areapoi", AreaPOIEntry.class.newInstance());
		list.put("skillline", SkillLineEntry.class.newInstance());
		// list.put("creaturemovementinfo",
		// CreatureMovementInfoEntry.class.newInstance());
		// list.put("charhairtextures",
		// CharHairTexturesEntry.class.newInstance());
		// list.put("transportanimation",
		// TransportAnimationEntry.class.newInstance());
		list.put("skilllineability", SkillLineAbilityEntry.class.newInstance());
		// list.put("worldstatezonesounds",
		// WorldStateZoneSoundsEntry.class.newInstance());
		// list.put("soundemitters", SoundEmittersEntry.class.newInstance());
		list.put("spellitemenchantment",
				SpellItemEnchantmentEntry.class.newInstance());
		// list.put("gtchancetomeleecritbase",
		// gtChanceToMeleeCritBaseEntry.class.newInstance());
		// list.put("characterfacialhairstyles",
		// CharacterFacialHairStylesEntry.class.newInstance());
		// list.put("spellvisualkitmodelattach",
		// SpellVisualKitModelAttachEntry.class.newInstance());
		// list.put("dancemoves", DanceMovesEntry.class.newInstance());
		list.put("durabilityquality",
				DurabilityQualityEntry.class.newInstance());
		// list.put("lightskybox", LightSkyboxEntry.class.newInstance());
		list.put("lock", LockEntry.class.newInstance());
		list.put("summonproperties", SummonPropertiesEntry.class.newInstance());
		list.put("questxp", QuestXPEntry.class.newInstance());
		list.put("worldmapoverlay", WorldMapOverlayEntry.class.newInstance());
		// list.put("spelleffectcamerashakes",
		// SpellEffectCameraShakesEntry.class.newInstance());
		// list.put("wowerror_strings",
		// WowError_StringsEntry.class.newInstance());
		// list.put("lightparams", LightParamsEntry.class.newInstance());
		// list.put("terraintypesounds",
		// TerrainTypeSoundsEntry.class.newInstance());
		list.put("itemset", ItemSetEntry.class.newInstance());
		// list.put("petitiontype", PetitionTypeEntry.class.newInstance());
		// list.put("spellvisualprecasttransitions",
		// SpellVisualPrecastTransitionsEntry.class.newInstance());
		// list.put("emotestextdata", EmotesTextDataEntry.class.newInstance());
		// list.put("gametables", GameTablesEntry.class.newInstance());
		// list.put("petpersonality", PetPersonalityEntry.class.newInstance());
		// list.put("spellvisualeffectname",
		// SpellVisualEffectNameEntry.class.newInstance());
		list.put("emotestext", EmotesTextEntry.class.newInstance());
		list.put("item", ItemEntry.class.newInstance());
		// list.put("exhaustion", ExhaustionEntry.class.newInstance());
		// list.put("gtnpcmanacostscaler",
		// gtNPCManaCostScalerEntry.class.newInstance());
		list.put("spellduration", SpellDurationEntry.class.newInstance());
		// list.put("footstepterrainlookup",
		// FootstepTerrainLookupEntry.class.newInstance());
		// list.put("attackanimkits", AttackAnimKitsEntry.class.newInstance());
		list.put("glyphproperties", GlyphPropertiesEntry.class.newInstance());
		// list.put("objecteffectpackage",
		// ObjectEffectPackageEntry.class.newInstance());
		// list.put("namesprofanity", NamesProfanityEntry.class.newInstance());
		// list.put("resistances", ResistancesEntry.class.newInstance());
		// list.put("cfg_configs", Cfg_ConfigsEntry.class.newInstance());
		// list.put("filedata", FileDataEntry.class.newInstance());
		// list.put("gmsurveyquestions",
		// GMSurveyQuestionsEntry.class.newInstance());
		// list.put("gtchancetomeleecrit",
		// gtChanceToMeleeCritEntry.class.newInstance());
		list.put("wmoareatable", WMOAreaTableEntry.class.newInstance());
		// list.put("servermessages", ServerMessagesEntry.class.newInstance());
		list.put("pvpdifficulty", PvpDifficultyEntry.class.newInstance());
		list.put("scalingstatdistribution",
				ScalingStatDistributionEntry.class.newInstance());
		// list.put("footprinttextures",
		// FootprintTexturesEntry.class.newInstance());
		// list.put("holidaydescriptions",
		// HolidayDescriptionsEntry.class.newInstance());
		list.put("areagroup", AreaGroupEntry.class.newInstance());
		// list.put("dungeonmap", DungeonMapEntry.class.newInstance());
		list.put("questfactionreward",
				QuestFactionRewardEntry.class.newInstance());
		// list.put("gtregenmpperspt",
		// gtRegenMPPerSptEntry.class.newInstance());
		// list.put("startup_strings",
		// Startup_StringsEntry.class.newInstance());
		// list.put("itemsubclassmask",
		// ItemSubClassMaskEntry.class.newInstance());
		// list.put("unitbloodlevels",
		// UnitBloodLevelsEntry.class.newInstance());
		// list.put("gtbarbershopcostbase",
		// gtBarberShopCostBaseEntry.class.newInstance());
		// list.put("lfgdungeonexpansion",
		// LFGDungeonExpansionEntry.class.newInstance());
		// list.put("lfgdungeongroup",
		// LFGDungeonGroupEntry.class.newInstance());
		// list.put("soundwatertype", SoundWaterTypeEntry.class.newInstance());
		list.put("questsort", QuestSortEntry.class.newInstance());
		list.put("taxipathnode", TaxiPathNodeEntry.class.newInstance());
		// list.put("sheathesoundlookups",
		// SheatheSoundLookupsEntry.class.newInstance());
		// list.put("npcsounds", NPCSoundsEntry.class.newInstance());
		list.put("weather", WeatherEntry.class.newInstance());
		// list.put("objecteffectmodifier",
		// ObjectEffectModifierEntry.class.newInstance());
		list.put("chartitles", CharTitlesEntry.class.newInstance());
		// list.put("soundsamplepreferences",
		// SoundSamplePreferencesEntry.class.newInstance());
		list.put("durabilitycosts", DurabilityCostsEntry.class.newInstance());
		// list.put("creaturedisplayinfoextra",
		// CreatureDisplayInfoExtraEntry.class.newInstance());
		list.put("spell", SpellEntry.class.newInstance());
		// list.put("spelldifficulty",
		// SpellDifficultyEntry.class.newInstance());
		list.put("creaturedisplayinfo",
				CreatureDisplayInfoEntry.class.newInstance());
		// list.put("zoneintromusictable",
		// ZoneIntroMusicTableEntry.class.newInstance());
		list.put("chrclasses", ChrClassesEntry.class.newInstance());
		list.put("taxipath", TaxiPathEntry.class.newInstance());
		// list.put("camerashakes", CameraShakesEntry.class.newInstance());
		// list.put("gmsurveyanswers",
		// GMSurveyAnswersEntry.class.newInstance());
		list.put("spellfocusobject", SpellFocusObjectEntry.class.newInstance());
		// list.put("moviefiledata", MovieFileDataEntry.class.newInstance());
		// list.put("cfg_categories", Cfg_CategoriesEntry.class.newInstance());
		// list.put("soundfilter", SoundFilterEntry.class.newInstance());
		// list.put("transportphysics",
		// TransportPhysicsEntry.class.newInstance());
		list.put("spellrange", SpellRangeEntry.class.newInstance());
		list.put("chrraces", ChrRacesEntry.class.newInstance());
		// list.put("groundeffecttexture",
		// GroundEffectTextureEntry.class.newInstance());
		// list.put("skilltiers", SkillTiersEntry.class.newInstance());
		list.put("spellitemenchantmentcondition",
				SpellItemEnchantmentConditionEntry.class.newInstance());
		// list.put("paperdollitemframe",
		// PaperDollItemFrameEntry.class.newInstance());
		// list.put("animationdata", AnimationDataEntry.class.newInstance());
		list.put("chatchannels", ChatChannelsEntry.class.newInstance());
		// list.put("worldmaptransforms",
		// WorldMapTransformsEntry.class.newInstance());
		list.put("itemlimitcategory",
				ItemLimitCategoryEntry.class.newInstance());
		// list.put("vehicle", VehicleEntry.class.newInstance());
		// list.put("screeneffect", ScreenEffectEntry.class.newInstance());
		// list.put("gtoctregenhp", gtOCTRegenHPEntry.class.newInstance());
		// list.put("objecteffect", ObjectEffectEntry.class.newInstance());
		// list.put("stringlookups", StringLookupsEntry.class.newInstance());
		// list.put("gtoctclasscombatratingscalar",
		// gtOCTClassCombatRatingScalarEntry.class.newInstance());
		// list.put("weaponimpactsounds",
		// WeaponImpactSoundsEntry.class.newInstance());
		list.put("currencytypes", CurrencyTypesEntry.class.newInstance());
		// list.put("factiongroup", FactionGroupEntry.class.newInstance());
		// list.put("unitblood", UnitBloodEntry.class.newInstance());
		// list.put("spelldispeltype",
		// SpellDispelTypeEntry.class.newInstance());
		// list.put("spellvisualkitareamodel",
		// SpellVisualKitAreaModelEntry.class.newInstance());
		// list.put("achievement_criteria",
		// Achievement_CriteriaEntry.class.newInstance());
		// list.put("languages", LanguagesEntry.class.newInstance());
		// list.put("groundeffectdoodad",
		// GroundEffectDoodadEntry.class.newInstance());
		// list.put("vocaluisounds", VocalUISoundsEntry.class.newInstance());
		list.put("gemproperties", GemPropertiesEntry.class.newInstance());
		// list.put("itemgroupsounds",
		// ItemGroupSoundsEntry.class.newInstance());
		// list.put("gmsurveysurveys",
		// GMSurveySurveysEntry.class.newInstance());
		// list.put("stationery", StationeryEntry.class.newInstance());
		// list.put("itemvisuals", ItemVisualsEntry.class.newInstance());
		list.put("spellrunecost", SpellRuneCostEntry.class.newInstance());
		// list.put("worldchunksounds",
		// WorldChunkSoundsEntry.class.newInstance());
		// list.put("loadingscreentaxisplines",
		// LoadingScreenTaxiSplinesEntry.class.newInstance());
		// list.put("objecteffectgroup",
		// ObjectEffectGroupEntry.class.newInstance());
		list.put("itembagfamily", ItemBagFamilyEntry.class.newInstance());
		list.put("mapdifficulty", MapDifficultyEntry.class.newInstance());
		// list.put("package", PackageEntry.class.newInstance());
		// list.put("itempurchasegroup",
		// ItemPurchaseGroupEntry.class.newInstance());
		// list.put("bannedaddons", BannedAddOnsEntry.class.newInstance());
		list.put("battlemasterlist", BattlemasterListEntry.class.newInstance());
		// list.put("spellmissilemotion",
		// SpellMissileMotionEntry.class.newInstance());
		// list.put("itemsubclass", ItemSubClassEntry.class.newInstance());
		// list.put("gameobjectartkit",
		// GameObjectArtKitEntry.class.newInstance());
		// list.put("weaponswingsounds2",
		// WeaponSwingSounds2Entry.class.newInstance());
		// list.put("gtoctregenmp", gtOCTRegenMPEntry.class.newInstance());
		list.put("itemdisplayinfo", ItemDisplayInfoEntry.class.newInstance());
		list.put("creaturefamily", CreatureFamilyEntry.class.newInstance());
		// list.put("charbaseinfo", CharBaseInfoEntry.class.newInstance());
		// list.put("overridespelldata",
		// OverrideSpellDataEntry.class.newInstance());
		// list.put("questinfo", QuestInfoEntry.class.newInstance());
		// list.put("vehicleuiindicator",
		// VehicleUIIndicatorEntry.class.newInstance());
		list.put("factiontemplate", FactionTemplateEntry.class.newInstance());
		// list.put("teamcontributionpoints",
		// TeamContributionPointsEntry.class.newInstance());
		// list.put("soundfilterelem",
		// SoundFilterElemEntry.class.newInstance());
		list.put("gameobjectdisplayinfo",
				GameObjectDisplayInfoEntry.class.newInstance());
		// list.put("namegen", NameGenEntry.class.newInstance());
		list.put("mailtemplate", MailTemplateEntry.class.newInstance());
		list.put("scalingstatvalues",
				ScalingStatValuesEntry.class.newInstance());
		// list.put("emotestextsound",
		// EmotesTextSoundEntry.class.newInstance());
		// list.put("gtchancetospellcritbase",
		// gtChanceToSpellCritBaseEntry.class.newInstance());
		// list.put("pagetextmaterial",
		// PageTextMaterialEntry.class.newInstance());
		// list.put("gmsurveycurrentsurvey",
		// GMSurveyCurrentSurveyEntry.class.newInstance());
		// list.put("soundproviderpreferences",
		// SoundProviderPreferencesEntry.class.newInstance());
		// list.put("videohardware", VideoHardwareEntry.class.newInstance());
		list.put("areatable", AreaTableEntry.class.newInstance());
		list.put("emotes", EmotesEntry.class.newInstance());
		// list.put("dungeonencounter",
		// DungeonEncounterEntry.class.newInstance());
		list.put("movie", MovieEntry.class.newInstance());
		// list.put("deaththudlookups",
		// DeathThudLookupsEntry.class.newInstance());
		list.put("achievement", AchievementEntry.class.newInstance());
		// list.put("lfgdungeons", LFGDungeonsEntry.class.newInstance());
		// list.put("languagewords", LanguageWordsEntry.class.newInstance());
		// list.put("worldmapcontinent",
		// WorldMapContinentEntry.class.newInstance());
		// list.put("spellvisualkit", SpellVisualKitEntry.class.newInstance());
		// list.put("spellmissile", SpellMissileEntry.class.newInstance());
		list.put("faction", FactionEntry.class.newInstance());
		list.put("creaturespelldata",
				CreatureSpellDataEntry.class.newInstance());
		// list.put("spellcategory", SpellCategoryEntry.class.newInstance());
		// list.put("uisoundlookups", UISoundLookupsEntry.class.newInstance());
		list.put("spellcasttimes", SpellCastTimesEntry.class.newInstance());
		// list.put("itempetfood", ItemPetFoodEntry.class.newInstance());
		// list.put("lightintband", LightIntBandEntry.class.newInstance());
		list.put("randproppoints", RandPropPointsEntry.class.newInstance());
		// list.put("gtchancetospellcrit",
		// gtChanceToSpellCritEntry.class.newInstance());
		list.put("talenttab", TalentTabEntry.class.newInstance());
		// list.put("declinedword", DeclinedWordEntry.class.newInstance());
		// list.put("particlecolor", ParticleColorEntry.class.newInstance());
		list.put("worldsafelocs", WorldSafeLocsEntry.class.newInstance());
		list.put("itemrandomsuffix", ItemRandomSuffixEntry.class.newInstance());
		list.put("worldmaparea", WorldMapAreaEntry.class.newInstance());
		// list.put("skillraceclassinfo",
		// SkillRaceClassInfoEntry.class.newInstance());
		// list.put("material", MaterialEntry.class.newInstance());
		// list.put("terraintype", TerrainTypeEntry.class.newInstance());
		// list.put("soundentriesadvanced",
		// SoundEntriesAdvancedEntry.class.newInstance());
		list.put("barbershopstyle", BarberShopStyleEntry.class.newInstance());
		// list.put("light", LightEntry.class.newInstance());
		list.put("itemextendedcost", ItemExtendedCostEntry.class.newInstance());
		String[] children = dir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".dbc");
			}
		});
		if (children == null) {
			System.out.println("Directory with dbc-files not exist");
		} else {
			threadPoolManager.start();
			for (int i = 0; i < children.length; i++) {
				// Get filename of file or directory
				final String filename = children[i];
				final boolean mode = full;
				final String normalname = filename.substring(0,
						filename.length() - 4).toLowerCase();
				if (list.containsKey(normalname)) {
					threadPoolManager.schedule(new Runnable() {
						@SuppressWarnings("unchecked")
						@Override
						public void run() {
							DBCDataLoader.saveDBC2XML(list.get(normalname)
									.getClass(), "./dbc/" + filename, "./xml/",
									mode);
							list.remove(normalname);
						}
					},0);

				}
			}
			PoolStats ps = threadPoolManager
					.fillPoolStats(ThreadPoolType.SCHEDULED);
			int condition = ps.getActiveCount();
			System.out.println("Task Count: " + ps.getTaskCount()); 
			do {
				System.out.println("Active thread: " + condition + "\n"
						+ "Complite thread: " + ps.getCompletedTaskCount());
				Thread.sleep(300L);
				ps = threadPoolManager.fillPoolStats(ThreadPoolType.SCHEDULED);
			} while ((condition = ps.getActiveCount()) > 0);
			threadPoolManager.stop();
			System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]")
					.format(new Date()) + " End");
			long end = System.currentTimeMillis();
			System.out.println("DBCEncoding loading took: " + (end - start) + "ms");
		}
	}
}
